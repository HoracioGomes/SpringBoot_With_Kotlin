package br.com.teste.data.vo.v1

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.dozermapper.core.Mapping
import jakarta.persistence.Column
import org.springframework.hateoas.RepresentationModel

data class PersonVO(
    @Mapping("id")
    var key: Long = 0,

//    @field:JsonProperty("nickname")
    var firstName: String = "",

    var lastName: String = "",

    var address: String = "",

//    @field:JsonIgnore
    var gender: String = ""
) : RepresentationModel<PersonVO>()
