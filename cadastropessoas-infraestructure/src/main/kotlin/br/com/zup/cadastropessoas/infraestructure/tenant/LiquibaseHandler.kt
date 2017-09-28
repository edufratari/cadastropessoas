package br.com.zup.cadastropessoas.infraestructure.tenant

interface LiquibaseHandler {

    fun handleTenant()
    fun handleTenant(organization : String, application: String)
    fun handleTenant(tenant: String)

}