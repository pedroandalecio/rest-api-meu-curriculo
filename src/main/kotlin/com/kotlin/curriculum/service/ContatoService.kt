package com.kotlin.curriculum.service

import com.kotlin.curriculum.enum.TipoContato
import com.kotlin.curriculum.model.Contato
import com.kotlin.curriculum.repository.ContatoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContatoService {

    @Autowired lateinit var contatoRepository: ContatoRepository

    fun obterTodosContatos(): List<Contato>{ return contatoRepository.findAll() }
    fun obterContatoPorId(id: Long): Contato { return contatoRepository.findById(id).orElseThrow { RuntimeException("Registro não encontrado")} }
    fun obterContatoPorTipo(tipoContato: TipoContato): Contato { return contatoRepository.findByTipoContato(tipoContato).orElseThrow { RuntimeException("Registro não encontrado")} }

}
