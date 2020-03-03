package com.kotlin.curriculum.repository

import com.kotlin.curriculum.enum.TipoContato
import com.kotlin.curriculum.model.Contato
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ContatoRepository : JpaRepository<Contato, Long> {

    fun findByTipoContato(tipoContato: TipoContato): Optional<Contato>

    fun findByIdAndTipoContato(id: Long, tipoContato: TipoContato): Optional<Contato>
}