package com.dantesys.orcamento.repository

import com.dantesys.orcamento.Projeto
import org.springframework.data.repository.CrudRepository

interface ProjetoRepository: CrudRepository<Projeto, Int>