package com.dantesys.orcamento.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Modelo(
    var nome: String,
    var espessura: Int,
    var preco: Float,
    @ManyToOne
    val user: User,
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    val id:Int=0,
)
