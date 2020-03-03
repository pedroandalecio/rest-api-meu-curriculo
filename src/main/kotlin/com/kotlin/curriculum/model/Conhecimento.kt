package com.kotlin.curriculum.model

import com.kotlin.curriculum.enum.TipoConhecimento
import javax.persistence.*

@Entity
data class Conhecimento (
        var titulo: String ="",

        @Column(name = "ANOS_EXPERIENCIA")
        var anosExperiencia: Int = 0,

        @Enumerated(EnumType.STRING)
        @Column(name = "TIPO_CONHECIMENTO")
        var tipoConhecimento: TipoConhecimento = TipoConhecimento.NENHUM,

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONHECIMENTO")
        @SequenceGenerator(name = "SEQ_CONHECIMENTO", sequenceName = "SEQ_CONHECIMENTO", allocationSize = 1, initialValue = 1)
        var id: Long = 0
)