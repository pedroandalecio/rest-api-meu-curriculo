package com.kotlin.curriculum.controller

import com.kotlin.curriculum.model.Conhecimento
import com.kotlin.curriculum.service.ConhecimentoService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/conhecimentos")
@Api(value = "Conhecimentos", description = "Conhecimentos profissionais")
class ConhecimentoController {

    @Autowired lateinit var conhecimentoService: ConhecimentoService

    @GetMapping(value = ["/{id}"]) @ApiOperation(value = "Retornar o conhecimento pelo id")
    fun conhecimento(@PathVariable id: Long): HttpEntity<Conhecimento> { return ResponseEntity(conhecimentoService.obterConhecimentoPorId(id), HttpStatus.OK) }

    @GetMapping("/todos") @ApiOperation(value = "Retornar todos os conhecimentos")
    fun conhecimentos(): ResponseEntity<List<Conhecimento>>{ return ResponseEntity(conhecimentoService.obterTodosConhecimentos(), HttpStatus.OK) }

    @GetMapping("/assunto") @ApiOperation(value = "Retornar todos os conhecimentos referentes a um assunto informado")
    fun conhecimentosPorAssunto(@RequestParam("assunto") assunto: String):ResponseEntity<List<Conhecimento>>{
        return ResponseEntity(conhecimentoService.obterConhecimentoPeloAssunto(assunto), HttpStatus.OK)
    }

}