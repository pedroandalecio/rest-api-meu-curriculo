package com.kotlin.curriculum.service

import com.kotlin.curriculum.enum.TipoHistorico
import com.kotlin.curriculum.model.Historico
import com.kotlin.curriculum.repository.HistoricoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HistoricoService {

    @Autowired private lateinit var historicoRepository: HistoricoRepository

    fun obtertTodosHistoricos(): List<Historico> { return historicoRepository.findAll() }

}