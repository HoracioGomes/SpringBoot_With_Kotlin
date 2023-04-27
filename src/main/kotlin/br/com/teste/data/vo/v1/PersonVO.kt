package br.com.teste.data.vo.v1

import jakarta.persistence.Column

data class PersonVO(

    var id: Long = 0,

    var firstName: String = "",

    var lastName: String = "",

    var address: String = "",

    var gender: String = ""
)
