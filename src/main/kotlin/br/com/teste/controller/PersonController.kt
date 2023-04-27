package br.com.teste.controller

import br.com.teste.data.vo.v1.PersonVO
import br.com.teste.mapper.DozerMapper
import br.com.teste.model.Person
import br.com.teste.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {


    @Autowired
    private lateinit var service: PersonService
    // var service: PersonService = PersonService()

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<PersonVO> {
        return DozerMapper().parseListObject(service.findAll(), PersonVO::class.java)
    }

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findById(@PathVariable(value = "id") id: Long): PersonVO {
        return DozerMapper().parseObject(service.findById(id), PersonVO::class.java)
    }

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun create(@RequestBody person: PersonVO): PersonVO {
        val entity: Person = DozerMapper().parseObject(person, Person::class.java)
        return DozerMapper().parseObject(service.create(entity), PersonVO::class.java)

    }

    @PutMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun update(@RequestBody person: PersonVO): PersonVO {
        val entity: Person = DozerMapper().parseObject(person, Person::class.java)
        return DozerMapper().parseObject(service.create(entity), PersonVO::class.java)
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}