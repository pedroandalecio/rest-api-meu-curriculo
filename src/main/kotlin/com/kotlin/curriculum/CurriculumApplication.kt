package com.kotlin.curriculum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CurriculumApplication

fun main(args: Array<String>) {
	runApplication<CurriculumApplication>(*args)
}
