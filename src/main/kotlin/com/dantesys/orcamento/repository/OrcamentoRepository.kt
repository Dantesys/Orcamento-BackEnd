package com.dantesys.orcamento.repository

import com.dantesys.orcamento.Orcamento
import org.springframework.data.repository.CrudRepository

interface OrcamentoRepository: CrudRepository<Orcamento, Int>