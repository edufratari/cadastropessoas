package br.com.zup.cadastropessoas.infraestructure.tenant

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "tenant", ignoreUnknownFields = true)
open class MultiTenantProperties {

    var prefix: String = ""
        get() = field.toLowerCase()

}