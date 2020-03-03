package com.kotlin.curriculum.controller

import com.kotlin.curriculum.model.Historico
import com.kotlin.curriculum.service.HistoricoService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/historicos")
@Api(value = "Históricos", description = "Históricos de formação e experiencias")
class HistoricoController {

    @Autowired lateinit var historicoService: HistoricoService

    @GetMapping @ApiOperation(value = "Retornar Historicos.")
    fun todos(): ResponseEntity<List<Historico>>{ return ResponseEntity(historicoService.obtertTodosHistoricos(), HttpStatus.OK) }

}