package com.dantesys.orcamento

import javax.persistence.*

@Entity
data class Projeto(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    val id:Int,
    @OneToMany
    val vidros:List<Vidro>,
    @OneToMany
    val ferragens:List<Ferragem>,
    val observacoes:String
)