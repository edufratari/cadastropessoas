package br.com.zup.cadastropessoas.web

import br.com.zup.cadastropessoas.web.config.ApplicationConfig
import org.springframework.boot.SpringApplication
import java.net.InetAddress

fun main(args: Array<String>) {
    val app = SpringApplication.run(ApplicationConfig::class.java, *args)

    val applicationName = app.environment.getProperty("spring.application.name")
    val contextPath = app.environment.getProperty("server.contextPath")
    val port = app.environment.getProperty("server.port")
    val hostAddress = InetAddress.getLocalHost().hostAddress
}