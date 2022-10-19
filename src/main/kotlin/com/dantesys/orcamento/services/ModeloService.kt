package com.dantesys.orcamento.services

import com.dantesys.orcamento.entities.Modelo
import com.dantesys.orcamento.repositories.ModeloRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ModeloService(private var modeloRepository: ModeloRepository) {
    fun save(modelo:Modelo):Modelo{
        return modeloRepository.save(modelo)
    }
    fun findAll(): MutableIterable<Modelo> {
        return modeloRepository.findAll()
    }
    fun findByIdOrNull(id:Int): Modelo? {
        return modeloRepository.findByIdOrNull(id)
    }
    fun delete(modelo: Modelo) {
        return modeloRepository.delete(modelo)
    }
}