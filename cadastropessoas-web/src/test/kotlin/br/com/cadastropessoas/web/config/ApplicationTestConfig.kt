package br.com.cadastropessoas.web.config

import br.com.cadastropessoas.web.ApplicationConfig
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import


@Configuration
@Import(ApplicationConfig::class)
open class ApplicationTestConfig
