package br.com.teste.controller

import br.com.teste.data.vo.v1.PersonVO
import br.com.teste.data.vo.v2.PersonVO as PersonVOV2
import br.com.teste.mapper.DozerMapper
import br.com.teste.mapper.custom.PersonMapper
import br.com.teste.model.Person
import br.com.teste.services.PersonService
import br.com.teste.util.MediaType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {


    @Autowired
    private lateinit var service: PersonService
    // var service: PersonService = PersonService()

    @Autowired
    private lateinit var personMapper: PersonMapper

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YML_VALUE])
    fun findAll(): List<PersonVO> {
        return DozerMapper().parseListObject(service.findAll(), PersonVO::class.java)
    }

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YML_VALUE]
    )
    fun findById(@PathVariable(value = "id") id: Long): PersonVO {
        return DozerMapper().parseObject(service.findById(id), PersonVO::class.java)
    }

    @PostMapping(
        value = ["/v1"],
        consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YML_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YML_VALUE]
    )
    fun create(@RequestBody person: PersonVO): PersonVO {
        val entity: Person = DozerMapper().parseObject(person, Person::class.java)
        return DozerMapper().parseObject(service.create(entity), PersonVO::class.java)

    }

    @PostMapping(
        value = ["/v2"],
        consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YML_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YML_VALUE]
    )
    fun create(@RequestBody person: PersonVOV2): PersonVOV2 {
        val entity: Person = personMapper.parseToEntity(person)
        return personMapper.parseToVO(service.create(entity))
    }

    @PutMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YML_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YML_VALUE]
    )
    fun update(@RequestBody person: PersonVO): PersonVO {
        val entity: Person = DozerMapper().parseObject(person, Person::class.java)
        return DozerMapper().parseObject(service.create(entity), PersonVO::class.java)
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YML_VALUE]
    )
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}