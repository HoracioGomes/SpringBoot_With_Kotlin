package br.com.teste.mapper.custom

import br.com.teste.data.vo.v2.PersonVO
import br.com.teste.model.Person
import org.springframework.stereotype.Service
import java.util.Date

@Service
class PersonMapper {

    fun parseToVO(entity: Person): PersonVO {
        val vo: PersonVO = PersonVO()
        vo.id = entity.id
        vo.address = entity.address
        vo.gender = entity.gender
        vo.firstName = entity.firstName
        vo.lastName = entity.lastName
        vo.birthiday = Date()
        return vo
    }

    fun parseToEntity(vo: PersonVO): Person {
        val entity: Person = Person()
        entity.id = vo.id
        entity.address = vo.address
        entity.gender = vo.gender
        entity.firstName = vo.firstName
        entity.lastName = vo.lastName
        return entity
    }
}