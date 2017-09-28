package br.com.zup.cadastropessoas.api.request

data class CreatePersonRequest(val id: String?,
                               val name: String?,
                               val cpf: String?,
                               val rg: String?,
                               val address: String?)