package br.com.zup.cadastropessoas.web.config

import br.com.zup.cadastropessoas.jdbc.repository.config.RepositoryConfig
import br.com.zup.realwave.common.context.web.boot.TrackingConfig
import br.com.zup.realwave.common.graylog.GraylogConfig
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@Configuration
@EnableScheduling
@Import(
        GraylogConfig::class,
        RepositoryConfig::class,
        TrackingConfig::class
)
@ComponentScan(basePackages = arrayOf(
        "br.com.zup.cadastropessoas",
        "br.com.zup.cadastropessoas.infraestructure",
        "br.com.zup.realwave.common.exception.handler"))
@EnableAutoConfiguration(exclude = arrayOf(LiquibaseAutoConfiguration::class))
open class ApplicationConfig