package com.kotlin.curriculum.repository

import com.kotlin.curriculum.enum.TipoHistorico
import com.kotlin.curriculum.model.Historico
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface HistoricoRepository : JpaRepository<Historico, Long> {
    fun findAllByTipoHistorico(tipoHistorico: TipoHistorico): List<Historico>

    fun findAllByTipoHistoricoOrderByAnoInicioDesc(tipoHistorico: TipoHistorico): List<Historico>

    fun findByIdAndTipoHistorico(id: Long, tipoHistorico: TipoHistorico): Optional<Historico>
}