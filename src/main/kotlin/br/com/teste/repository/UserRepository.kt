package br.com.teste.repository

import br.com.teste.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserRepository : JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userName =:userName")
    fun findByUserName(@Param("userName") userName: String?): User?
}