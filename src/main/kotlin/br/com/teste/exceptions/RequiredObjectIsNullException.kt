package br.com.teste.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.*

@ResponseStatus(HttpStatus.BAD_REQUEST)
class RequiredObjectIsNullException : RuntimeException {
    constructor() : super("Its not allowed to persist a null object")
    constructor(exception: String?) : super(exception)
}