package com.kotlin.curriculum.controller

import com.kotlin.curriculum.enum.TipoContato
import com.kotlin.curriculum.model.Contato
import com.kotlin.curriculum.service.ContatoService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contatos")
@Api(value = "Contatos", description = "Meios de contato")
class ContatoController {

    @Autowired lateinit var contatoService: ContatoService

    @GetMapping(value = ["/{id}"]) @ApiOperation(value = "Retornar o contato pelo id")
    fun contato(@PathVariable id: Long): HttpEntity<Contato> { return ResponseEntity<Contato>(contatoService.obterContatoPorId(id), HttpStatus.OK) }

    @GetMapping("/tipo") @ApiOperation(value = "Retornar o contato por Tipo")
    fun contatoPorTipo(@RequestParam("tipo") tipo: TipoContato): HttpEntity<Contato> { return ResponseEntity<Contato>(contatoService.obterContatoPorTipo(tipo), HttpStatus.OK) }

    @GetMapping("/todos") @ApiOperation(value = "Retornar todos os contatos")
    fun contatos(): ResponseEntity<List<Contato>>{ return ResponseEntity(contatoService.obterTodosContatos(), HttpStatus.OK) }

}
