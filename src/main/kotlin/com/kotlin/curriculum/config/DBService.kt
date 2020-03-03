package com.kotlin.curriculum.config

import com.kotlin.curriculum.enum.TipoConhecimento
import com.kotlin.curriculum.enum.TipoContato
import com.kotlin.curriculum.enum.TipoHistorico
import com.kotlin.curriculum.model.Conhecimento
import com.kotlin.curriculum.model.Contato
import com.kotlin.curriculum.model.Curriculo
import com.kotlin.curriculum.model.Historico
import com.kotlin.curriculum.repository.ConhecimentoRepository
import com.kotlin.curriculum.repository.ContatoRepository
import com.kotlin.curriculum.repository.CurriculoRepository
import com.kotlin.curriculum.repository.HistoricoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration

@Configuration
class DBService : CommandLineRunner {

    @Autowired
    lateinit var curriculoRepositorio: CurriculoRepository;

    @Autowired
    lateinit var historicoRepository: HistoricoRepository

    @Autowired
    lateinit var conhecimentoRepository: ConhecimentoRepository

    @Autowired
    lateinit var contatoRepository: ContatoRepository

    override fun run(vararg args: String?) {

        contatoRepository.deleteAll()
        conhecimentoRepository.deleteAll()
        historicoRepository.deleteAll()
        curriculoRepositorio.deleteAll()
        val curriculo = preencheCurriculo()
        curriculoRepositorio.save(curriculo)
    }

    private fun preencheCurriculo(): Curriculo {
        val curriculo = Curriculo(1L)
        curriculo.primeiroNome = "PEDRO"
        curriculo.ultimoNome = "GONTIJO"
        curriculo.profissao = "PLENO JAVA DEVELOPER"
        curriculo.resumo = """Desenvolvedor Java Backend, com experiência profissional em desenvolvimento de sistemas desde a concepção até a entrega 
                              (backend, frontend, banco de dados, levantamento de requisitos e análise de sistemas).""".trimMargin()

        val historicos: MutableList<Historico> = mutableListOf()

        preencheHistorico(historicos)
        preencheEducacao(historicos)

        curriculo.historicos = historicos

        preencheContatos(curriculo)
        preencheConhecimentos(curriculo)

        return curriculo
    }

    private fun preencheHistorico(historicos: MutableList<Historico>) {

        var historico = Historico("Pleno Java / Full Stack Developer | Remote")
        historico.instituicao = "Code Square"
        historico.anoInicio = "2020"
        historico.descricao = "Desenvolvedor Pleno Java / Full Stack trabalhando remotamente no desenvolvimento de sistemas da empresa, " +
                              "as tecnologias mais utilizados são Java 8 e Angular 7, e no momento estamos iniciando um novo projeto com kotlin."
        historico.tipoHistorico = TipoHistorico.EXPERIENCIA
        historicos.add(historico)

        var historico1 = Historico("Pleno Java Developer | Remote")
        historico1.instituicao = "Real Calçados e Confecções"
        historico1.anoInicio = "2014"
        historico1.descricao = "Desenvolvedor Java / Full Stack trabalhando remotamente no desenvolvimento de sistemas da empresa (back-end, front-end, banco de dados, " +
                               "levantamento de requisitos e análise de sistemas)."
        historico1.tipoHistorico = TipoHistorico.EXPERIENCIA
        historicos.add(historico1)

        var historico2 = Historico("Pleno Java Developer | Remote")
        historico2.instituicao = "AIS DIGITAL"
        historico2.anoInicio = "2019"
        historico2.anoFim = "2020"
        historico2.descricao = "Projeto temporário remoto, com participação no desenvolvimento do backend."
        historico2.tipoHistorico = TipoHistorico.EXPERIENCIA
        historicos.add(historico2)

        var historico3 = Historico("Professor Universitário")
        historico3.instituicao = "Faculdade Finom"
        historico3.anoInicio = "2013"
        historico3.anoFim = "2014"
        historico3.descricao = "Professor : Informática e Lógica e Linguagem de Programação Básica."
        historico3.tipoHistorico = TipoHistorico.EXPERIENCIA
        historicos.add(historico3)

        var historico4 = Historico("Analista de Sistemas")
        historico4.instituicao = "Ultracopy Ltda"
        historico4.anoInicio = "2011"
        historico4.anoFim = "2014"
        historico4.descricao = "Responsável pelo setor de Tecnologia da Informação, desenvolvimento de soluções, suporte técnico e planejamento."
        historico4.tipoHistorico = TipoHistorico.EXPERIENCIA
        historicos.add(historico4)

        var historico5 = Historico("Analista de Sistemas")
        historico5.instituicao = "WD Agroindustrial Ltda"
        historico5.anoInicio = "2010"
        historico5.anoFim = "2011"
        historico5.descricao = "Assistente de Tecnologia da Informação, suporte a usuários, configuração e manutenção de computadores."
        historico5.tipoHistorico = TipoHistorico.EXPERIENCIA
        historicos.add(historico5)

    }

    private fun preencheEducacao(historicos: MutableList<Historico>) {
        //EDUCAÇÃO
        var educacao = Historico("Bacharelado em Sistemas de Informação")
        educacao.instituicao = "Centro Universitário de Patos de Minas - Unipam"
        educacao.anoFim = "2012"
        educacao.descricao = "Ensino superior completo em dezembro de 2012 no Centro Universitário de Patos de Minas - Unipam"
        educacao.tipoHistorico = TipoHistorico.EDUCACAO
        historicos.add(educacao)
    }

    private fun preencheConhecimentos(curriculo: Curriculo) {
        //CONHECIMENTOS
        var conhecimento1 = Conhecimento("Java", 8, TipoConhecimento.ESPECIFICO)
        var conhecimento2 = Conhecimento("POO", 8, TipoConhecimento.ESPECIFICO)
        var conhecimento3 = Conhecimento("Spring Data JPA", 3, TipoConhecimento.ESPECIFICO)
        var conhecimento4 = Conhecimento("Hibernate / JPA", 7, TipoConhecimento.ESPECIFICO)
        var conhecimento5 = Conhecimento("GitLab / GitHub", 7, TipoConhecimento.ESPECIFICO)
        var conhecimento6 = Conhecimento("Maven", 5, TipoConhecimento.ESPECIFICO)
        var conhecimento7 = Conhecimento("MySQL / PostgreSQL", 8, TipoConhecimento.ESPECIFICO)
        var conhecimento8 = Conhecimento("Linux/GNU", 3, TipoConhecimento.ESPECIFICO)
        var conhecimento9 = Conhecimento("JSF / Primefaces", 7, TipoConhecimento.ESPECIFICO)
        var conhecimento10 = Conhecimento("JUnit", 2, TipoConhecimento.ESPECIFICO)
        var conhecimento11 = Conhecimento("Swagger", 1, TipoConhecimento.ESPECIFICO)
        var conhecimento12 = Conhecimento("TypeScript", 2, TipoConhecimento.ESPECIFICO)
        var conhecimento13 = Conhecimento("JDBC", 8, TipoConhecimento.ESPECIFICO)
        var conhecimento14 = Conhecimento("Angular", 3, TipoConhecimento.ESPECIFICO)
        var conhecimento15 = Conhecimento("Jenkins", 1, TipoConhecimento.ESPECIFICO)
        var conhecimento16 = Conhecimento("UML", 8, TipoConhecimento.ESPECIFICO)
        var conhecimento17 = Conhecimento("Spring Boot", 3, TipoConhecimento.ESPECIFICO)
        var conhecimento18 = Conhecimento("Jira", 1, TipoConhecimento.ESPECIFICO)
        var conhecimento19 = Conhecimento("Flyway", 2, TipoConhecimento.ESPECIFICO)
        var conhecimento20 = Conhecimento("Ionic Framework", 3, TipoConhecimento.ESPECIFICO)
        var conhecimento21 = Conhecimento("Spring Security", 5, TipoConhecimento.ESPECIFICO)
        var conhecimento22 = Conhecimento("Docker", 1, TipoConhecimento.ESPECIFICO)
        var conhecimento23 = Conhecimento("SQL", 8, TipoConhecimento.ESPECIFICO)
        var conhecimento24 = Conhecimento("RESTful / WebServices", 3, TipoConhecimento.ESPECIFICO)
        var conhecimento25 = Conhecimento("Banco de dados Oracle", 1, TipoConhecimento.ESPECIFICO)
        var conhecimento26 = Conhecimento("HTML / CSS", 8, TipoConhecimento.ESPECIFICO)
        var conhecimento27 = Conhecimento("Scrum", 1, TipoConhecimento.ESPECIFICO)
        var conhecimento28 = Conhecimento("MongoDB", 1, TipoConhecimento.ESPECIFICO)
        var conhecimento29 = Conhecimento("Bootstrap", 5, TipoConhecimento.ESPECIFICO)
        var conhecimento30 = Conhecimento("Keycloak / Auth0", 1, TipoConhecimento.ESPECIFICO)
        var conhecimento31 = Conhecimento("Kotlin", 1, TipoConhecimento.ESPECIFICO)



        curriculo.conhecimentos = arrayListOf(conhecimento1, conhecimento2, conhecimento3, conhecimento4, conhecimento5, conhecimento6, conhecimento7, conhecimento8, conhecimento9,
                                              conhecimento10, conhecimento11, conhecimento12, conhecimento13, conhecimento14, conhecimento15, conhecimento16, conhecimento17, conhecimento18,
                                              conhecimento19, conhecimento20, conhecimento21, conhecimento22, conhecimento23, conhecimento24, conhecimento25, conhecimento26, conhecimento27,
                                              conhecimento28, conhecimento29, conhecimento30, conhecimento31)
    }

    private fun preencheContatos(curriculo: Curriculo) {
        var contatoTelefone = Contato("5575992426357", "Telefone", TipoContato.TELEFONE)
        var contatoEmail = Contato("pedroandalecio@hotmail.com", "E-Mail", TipoContato.EMAIL)
        var contatoFacebook = Contato("https://www.facebook.com/pedro.andalecio.3", "Facebook", TipoContato.FACEBOOK)
        var contatoSkype = Contato("pedro_andalecio", "Skype", TipoContato.SKYPE)
        var contatoLinkedin = Contato("https://www.linkedin.com/in/pedroandalecio/", "Linkedin", TipoContato.LINKEDIN)

        curriculo.contatos = arrayListOf(contatoTelefone, contatoEmail, contatoFacebook, contatoSkype, contatoLinkedin)
    }

}