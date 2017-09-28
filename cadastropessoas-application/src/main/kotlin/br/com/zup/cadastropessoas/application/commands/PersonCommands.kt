package br.com.zup.cadastropessoas.application.commands

import br.com.zup.cadastropessoas.domain.*

data class CreatePerson(val personId: PersonId,
                        val name: Name,
                        val cpf: Cpf,
                        val rg: Rg,
                        val address: Address)

data class UpdatePerson(val personId: PersonId,
                        val name: Name,
                        val cpf: Cpf,
                        val rg: Rg,
                        val address: Address)

data class DeletePerson(val personId: PersonId)

data class GetPerson(val personId: PersonId)

data class GetPersonByCpf(val cpf: Cpf)