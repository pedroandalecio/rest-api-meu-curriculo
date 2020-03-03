package com.kotlin.curriculum.model

import javax.persistence.*

@Entity
data class Curriculo(
        @Id
        var id: Long = 0L,

        @Column(length = 100, nullable = false, name = "PRIMEIRO_NOME")
        var primeiroNome: String = "",

        @Column(length = 100, nullable = false, name = "ULTIMO_NOME")
        var ultimoNome: String = ""
) {
    @Column(nullable = false)
    var resumo: String = "";

    @Column(length = 240, nullable = false)
    var profissao: String = ""

    @OneToMany(cascade = [CascadeType.ALL])
    var historicos: List<Historico>? = null

    @OneToMany(cascade = [CascadeType.ALL])
    var contatos: List<Contato>? = null

    @OneToMany(cascade = [CascadeType.ALL])
    var conhecimentos: List<Conhecimento>? = null
}