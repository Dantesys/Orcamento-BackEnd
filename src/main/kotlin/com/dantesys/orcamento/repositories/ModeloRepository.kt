package com.dantesys.orcamento.repositories

import com.dantesys.orcamento.entities.Modelo
import org.springframework.data.repository.CrudRepository

interface ModeloRepository: CrudRepository<Modelo, Int>