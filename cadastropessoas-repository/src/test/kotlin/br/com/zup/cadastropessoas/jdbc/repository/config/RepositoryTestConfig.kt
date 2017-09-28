package br.com.zup.cadastropessoas.jdbc.repository.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(RepositoryConfig::class)
@ComponentScan(basePackages = arrayOf("br.com.zup.cadastropessoas.jdbc.repository"))
open class RepositoryTestConfig
