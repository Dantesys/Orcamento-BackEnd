package com.dantesys.orcamento.services

import com.dantesys.orcamento.entities.User
import com.dantesys.orcamento.repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private var userRepository: UserRepository) {
    fun save(user: User):User{
        return userRepository.save(user)
    }
    fun getByEmail(email:String): User? {
        return userRepository.findByEmail(email)
    }
    fun getById(id:Int): Optional<User> {
        return userRepository.findById(id)
    }
}