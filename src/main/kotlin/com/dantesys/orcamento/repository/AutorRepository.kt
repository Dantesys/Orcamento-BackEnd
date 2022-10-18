package com.dantesys.orcamento.repository

import com.dantesys.orcamento.Autor
import org.springframework.data.repository.CrudRepository

interface AutorRepository: CrudRepository<Autor, Int>