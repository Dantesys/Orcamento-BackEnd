package com.dantesys.orcamento.repositories

import com.dantesys.orcamento.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int>{
    fun findByEmail(email:String):User?
}