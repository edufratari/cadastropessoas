package br.com.zup.cadastropessoas.api.request

import org.hibernate.validator.constraints.NotBlank

data class CreatePersonRequest(@field:NotBlank val name: String?,
                               @field:NotBlank val address: String?,
                               @field:NotBlank val cpf: String?,
                               @field:NotBlank val rg: String?)