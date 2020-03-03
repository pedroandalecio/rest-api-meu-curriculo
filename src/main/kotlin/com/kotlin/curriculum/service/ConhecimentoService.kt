package com.kotlin.curriculum.service

import com.kotlin.curriculum.model.Conhecimento
import com.kotlin.curriculum.repository.ConhecimentoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class ConhecimentoService {

    @Autowired lateinit var conhecimentoRepository: ConhecimentoRepository

    fun obterTodosConhecimentos(): List<Conhecimento> { return conhecimentoRepository.findAll() }
    fun obterConhecimentoPorId(id: Long): Conhecimento { return conhecimentoRepository.findById(id).orElseThrow({ RuntimeException("Registro não encontrado") }) }
    fun obterConhecimentoPeloAssunto(assunto: String): List<Conhecimento> { return conhecimentoRepository.findByTituloContainingIgnoreCase(assunto) }
}