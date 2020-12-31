package com.workspace.aocdataapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
class AocDataApiApplication

fun main(args: Array<String>) {
	runApplication<AocDataApiApplication>(*args)
}
