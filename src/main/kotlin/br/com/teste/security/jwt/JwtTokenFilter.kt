package br.com.teste.security.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean

class JwtTokenFilter(@field:Autowired private val tokenProvider: JwtTokenProvider) : GenericFilterBean() {
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, filterChain: FilterChain) {
        val token: String? = tokenProvider.resolveToken(request as HttpServletRequest)
        if (!token.isNullOrBlank() && tokenProvider.validateExpireDateToken(token)) {
            val auth: Authentication = tokenProvider.getAuthentication(token)
            SecurityContextHolder.getContext().authentication = auth
        }
        filterChain.doFilter(request, response)
    }

}