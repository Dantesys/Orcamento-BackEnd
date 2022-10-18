package com.dantesys.orcamento

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Autor(
    val nome: String,
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    val id: Int,
    val email: String,
    val senha: String,
    val provider: String
)
