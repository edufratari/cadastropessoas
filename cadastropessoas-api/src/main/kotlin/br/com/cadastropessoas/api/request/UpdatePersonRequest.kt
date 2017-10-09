package br.com.cadastropessoas.api.request

import org.hibernate.validator.constraints.NotBlank

data class UpdatePersonRequest(@field:NotBlank val name: String?,
                          @field:NotBlank val address: String?,
                          @field:NotBlank val cpf: String?,
                          @field:NotBlank val rg: String?)