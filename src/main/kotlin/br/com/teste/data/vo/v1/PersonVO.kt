package br.com.teste.data.vo.v1

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column

data class PersonVO(

    var id: Long = 0,

//    @field:JsonProperty("nickname")
    var firstName: String = "",

    var lastName: String = "",

    var address: String = "",

//    @field:JsonIgnore
    var gender: String = ""
)
