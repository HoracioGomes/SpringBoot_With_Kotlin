package br.com.teste.data.vo.v1

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import jakarta.persistence.Column
import org.springframework.hateoas.RepresentationModel

@JsonPropertyOrder("id", "firstName","lastName", "address", "gender")
data class PersonVO(
    @Mapping("id")
    @field:JsonProperty("id")
    var key: Long = 0,

//    @field:JsonProperty("nickname")
    var firstName: String = "",

    var lastName: String = "",

    var address: String = "",

//    @field:JsonIgnore
    var gender: String = ""
) : RepresentationModel<PersonVO>()
