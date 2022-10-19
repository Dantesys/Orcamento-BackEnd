package com.dantesys.orcamento

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Ferragem(
    @Id
    val codigo:Int,
    val nome:String
)
