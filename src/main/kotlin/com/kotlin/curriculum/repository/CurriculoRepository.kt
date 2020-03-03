package com.kotlin.curriculum.repository

import com.kotlin.curriculum.model.Curriculo
import org.springframework.data.jpa.repository.JpaRepository

interface CurriculoRepository: JpaRepository<Curriculo, Long>