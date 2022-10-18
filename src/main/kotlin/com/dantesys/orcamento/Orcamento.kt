package com.dantesys.orcamento

import javax.persistence.*

@Entity
data class Orcamento(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    val id: Int,
    val descricao: String,
    @OneToMany
    val vidros:List<Vidro>,
    @ManyToOne
    val autor: Autor
)
