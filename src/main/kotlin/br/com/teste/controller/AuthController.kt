package br.com.teste.controller

import br.com.teste.data.vo.v1.AccountCredentialsVO
import br.com.teste.services.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController {

    @Autowired
    private lateinit var service: AuthService

    @PostMapping(value = ["/signin"])
    fun sign(@RequestBody data: AccountCredentialsVO?): ResponseEntity<*> {
        return if (data!!.username.isNullOrBlank() || data.password.isNullOrBlank()) {
            ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request")
        } else service.sign(data!!)
    }

    @PutMapping(value = ["/refresh/{username}"])
    fun refreshToken(
        @RequestHeader("Authorization") refreshToken: String?,
        @PathVariable("username") username: String
    ): ResponseEntity<*> {
        return if (refreshToken.isNullOrBlank() || username.isNullOrBlank()) {
            ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request")
        } else service.refreshToken(username, refreshToken)
    }
}