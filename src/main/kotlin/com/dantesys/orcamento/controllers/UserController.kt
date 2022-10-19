package com.dantesys.orcamento.controllers

import com.dantesys.orcamento.dtos.LoginDTO
import com.dantesys.orcamento.dtos.Mensagem
import com.dantesys.orcamento.dtos.RegistrarDTO
import com.dantesys.orcamento.entities.User
import com.dantesys.orcamento.services.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService){
    @PostMapping("/register")
    fun register(@RequestBody data:RegistrarDTO):ResponseEntity<User>{
        val user = User(data.nome,data.email,data.password)
        user.setEncodePassword(data.password)
        return ResponseEntity.ok(userService.save(user))
    }
    @GetMapping("/login")
    fun login(@RequestBody data:LoginDTO,response: HttpServletResponse):ResponseEntity<Any>{
        val user = userService.getByEmail(data.email) ?: return ResponseEntity.badRequest().body(Mensagem("Usuario não encontrado"))
        if(!user.checkPW(data.password)){
            return ResponseEntity.badRequest().body(Mensagem("Senha incorreta"))
        }
        val issuer = user.id.toString()
        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis()+60*24*1000))
            .signWith(null,SignatureAlgorithm.HS512)
            .compact()
        val cookie = Cookie("jwt",jwt)
        cookie.isHttpOnly = true
        response.addCookie(cookie)
        return ResponseEntity.ok(Mensagem("Sucesso"))
    }
    @GetMapping("/logout")
    fun logout(response: HttpServletResponse):ResponseEntity<Any>{
        val cookie = Cookie("jwt",null)
        cookie.isHttpOnly = true
        cookie.maxAge = 0
        response.addCookie(cookie)
        return ResponseEntity.ok(Mensagem("Sucesso"))
    }
    @GetMapping("/me")
    fun user(@CookieValue("jwt") jwt:String?):ResponseEntity<Any>{
        try {
            if(jwt==null){
                return ResponseEntity.status(401).body(Mensagem("Não Autorizado"))
            }
            //VERIFICAR ATUALIZAÇÃO Jwts.parserBuilder().build().parseClaimsJws(jwt)
            val body = Jwts.parserBuilder().build().parseClaimsJws(jwt).body
            return ResponseEntity.ok(userService.getById(body.issuer.toInt()))
        } catch (e:Exception) {
            return ResponseEntity.status(401).body(Mensagem("Não Autorizado"))
        }
    }
}