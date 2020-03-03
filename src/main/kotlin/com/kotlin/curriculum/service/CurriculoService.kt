package com.kotlin.curriculum.service

import com.kotlin.curriculum.model.Curriculo
import com.kotlin.curriculum.repository.ConhecimentoRepository
import com.kotlin.curriculum.repository.ContatoRepository
import com.kotlin.curriculum.repository.CurriculoRepository
import com.kotlin.curriculum.repository.HistoricoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CurriculoService {

    @Autowired lateinit var curriculoRepository: CurriculoRepository
    @Autowired lateinit var historicoRepository: HistoricoRepository
    @Autowired lateinit var conhecimentoRepository: ConhecimentoRepository
    @Autowired lateinit var contatoRepository: ContatoRepository

    fun obterCurriculo(): Curriculo {

        val curriculo = curriculoRepository.findById(1L).orElseThrow { RuntimeException("Curriculo não encontrado!") }
            curriculo.historicos = historicoRepository.findAll()
            curriculo.conhecimentos = conhecimentoRepository.findAll()
            curriculo.contatos = contatoRepository.findAll()
        return curriculo;
    }

}