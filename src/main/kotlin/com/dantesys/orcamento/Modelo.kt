package com.dantesys.orcamento

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Modelo(
    val nome: String,
    val espessura: Int,
    val preco: Float,
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    val id:Int
)
