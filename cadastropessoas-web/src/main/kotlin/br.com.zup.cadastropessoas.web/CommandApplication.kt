package br.com.zup.cadastropessoas.web

import br.com.zup.cadastropessoas.web.config.ApplicationConfig
import org.springframework.boot.SpringApplication

fun main(args: Array<String>) {
    SpringApplication.run(ApplicationConfig::class.java, *args)
}