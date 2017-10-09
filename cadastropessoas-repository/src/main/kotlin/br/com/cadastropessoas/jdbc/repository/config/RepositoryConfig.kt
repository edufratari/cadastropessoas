package br.com.cadastropessoas.jdbc.repository.config

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

@Configuration
@ComponentScan(basePackages = arrayOf("br.com.zup.cadastropessoas.jdbc.repository"))
@EnableAutoConfiguration(exclude = arrayOf(DataSourceAutoConfiguration::class))
open class RepositoryConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    open fun dataSource() =
            DataSourceBuilder.create().build()!!

    @Bean
    open fun jdbcTemplate(dataSource: DataSource) =
            JdbcTemplate(dataSource)
}