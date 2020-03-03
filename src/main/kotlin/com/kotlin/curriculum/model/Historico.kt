package com.kotlin.curriculum.model

import com.kotlin.curriculum.enum.TipoHistorico
import javax.persistence.*

@Entity
data class Historico(

        var titulo: String = "",

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HISTORICO")
        @SequenceGenerator(name = "SEQ_HISTORICO", sequenceName = "SEQ_HISTORICO", allocationSize = 1, initialValue = 1)
        var id: Long = 0
) {
    var instituicao: String = ""

    var descricao: String = ""

    var anoInicio: String = ""

    var anoFim: String = ""

    @Column(name="LINK_REFERENCIA")
    var linkReferencia: String = ""

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_HISTORICO")
    var tipoHistorico: TipoHistorico = TipoHistorico.NENHUM
}