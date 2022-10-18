package com.dantesys.orcamento.controllers

import com.dantesys.orcamento.Autor
import com.dantesys.orcamento.Orcamento
import com.dantesys.orcamento.repository.OrcamentoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/orcamento")
class OrcamentoController(val repository: OrcamentoRepository){
    @GetMapping("/all")
    @ResponseBody
    fun getAllOrcamento(): Iterable<Orcamento>? {
        return repository.findAll()
    }
    @GetMapping("/{id}")
    @ResponseBody
    fun getSpecificOrcamento(@PathVariable id: Int): Orcamento? {
        return repository.findByIdOrNull(id)
    }
}