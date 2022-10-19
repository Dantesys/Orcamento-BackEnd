package com.dantesys.orcamento.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
    var nome: String,
    @Column(unique = true)
    var email: String,
    @JsonIgnore
    var password: String,
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    val id:Int = 0
){
    private val passwordEncoder = BCryptPasswordEncoder()
    fun setEncodePassword(pass:String){
        this.password = this.passwordEncoder.encode(pass)
    }
    fun checkPW(pass:String):Boolean{
        return this.passwordEncoder.matches(pass,this.password)
    }
}
