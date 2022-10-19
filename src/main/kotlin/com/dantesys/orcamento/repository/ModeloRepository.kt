package com.dantesys.orcamento.repository

import com.dantesys.orcamento.Modelo
import org.springframework.data.repository.CrudRepository

interface ModeloRepository: CrudRepository<Modelo, Int>