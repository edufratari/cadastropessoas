package br.com.zup.cadastropessoas.web.config

import br.com.zup.cadastropessoas.jdbc.repository.config.RepositoryConfig
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
        "br.com.zup.cadastropessoas",
        "br.com.zup.cadastropessoas.infraestructure"))
open class ApplicationConfig