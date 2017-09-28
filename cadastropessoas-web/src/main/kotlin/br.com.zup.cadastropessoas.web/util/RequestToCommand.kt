package br.com.zup.cadastropessoas.web.util

import br.com.zup.cadastropessoas.api.request.CreatePersonRequest
import br.com.zup.cadastropessoas.domain.*

fun CreatePersonRequest.toCommand() =
        br.com.zup.cadastropessoas.application.commands.CreatePerson(
                personId = PersonId(),
                name = Name(this.name),
                address = Address(this.address),
                cpf = Cpf(this.cpf),
                rg = Rg(this.rg)
        )