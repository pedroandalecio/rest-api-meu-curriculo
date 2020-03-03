package com.kotlin.curriculum.repository

import com.kotlin.curriculum.enum.TipoConhecimento
import com.kotlin.curriculum.model.Conhecimento
import org.springframework.data.jpa.repository.JpaRepository

interface ConhecimentoRepository : JpaRepository<Conhecimento, Long> {

    fun findByTituloContainingIgnoreCase(titulo: String): List<Conhecimento>

    fun findByTipoConhecimento(tipoConhecimento: TipoConhecimento): List<Conhecimento>

}