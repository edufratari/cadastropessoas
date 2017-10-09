package br.com.cadastropessoas.web

import br.com.cadastropessoas.jdbc.repository.config.RepositoryConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@Configuration
@EnableScheduling
@Import(
        RepositoryConfig::class
)
@ComponentScan(basePackages = arrayOf(
        "br.com.cadastropessoas",
        "br.com.cadastropessoas.infraestructure"))
open class ApplicationConfig