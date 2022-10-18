package com.dantesys.orcamento

import javax.persistence.*

@Entity
data class Vidro(
    val altura: Int,
    val largura: Int,
    @ManyToOne
    val tipo: Tipo,
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    val id:Int
)
