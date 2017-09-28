package br.com.zup.cadastropessoas.api.request

import org.jetbrains.annotations.NotNull

data class CreatePersonRequest(val id: String?,
                               val name: String?,
                               val cpf: String?,
                               val rg: String?,
                               val address: String?)