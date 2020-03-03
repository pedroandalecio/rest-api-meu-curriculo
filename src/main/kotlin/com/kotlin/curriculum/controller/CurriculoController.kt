package com.kotlin.curriculum.controller

import com.kotlin.curriculum.model.Curriculo
import com.kotlin.curriculum.service.CurriculoService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/curriculo")
@Api(value = "Curriculo", description = "Representação do curriculo completo")
class CurriculoController {

    @Autowired lateinit var curriculoService: CurriculoService

    @GetMapping @ApiOperation(value = "Retornar curriculo.")
    fun obterCurriculo(): HttpEntity<Curriculo> { return ResponseEntity(curriculoService.obterCurriculo(), HttpStatus.OK) }
}