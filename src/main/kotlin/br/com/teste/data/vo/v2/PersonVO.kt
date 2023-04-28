package br.com.teste.data.vo.v2

import jakarta.persistence.Column
import java.util.Date

data class PersonVO(

    var id: Long = 0,

    var firstName: String = "",

    var lastName: String = "",

    var address: String = "",

    var gender: String = "",

    var birthiday: Date? = null
)
