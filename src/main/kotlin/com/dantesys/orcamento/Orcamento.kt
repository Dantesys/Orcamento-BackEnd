package com.dantesys.orcamento

import javax.persistence.*

@Entity
data class Orcamento(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    val id: Int,
    val descricao: String,
    val cliente: String,
    @OneToMany
    val projetos:List<Projeto>,
    @ManyToOne
    val autor: Autor
)
