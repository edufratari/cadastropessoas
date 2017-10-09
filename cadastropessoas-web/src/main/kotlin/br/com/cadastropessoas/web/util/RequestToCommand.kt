package br.com.cadastropessoas.web.util

import br.com.cadastropessoas.application.commands.CreatePerson
import br.com.cadastropessoas.application.commands.UpdatePerson
import br.com.cadastropessoas.domain.*
import br.com.cadastropessoas.web.request.CreatePersonRequest
import br.com.cadastropessoas.web.request.UpdatePersonRequest

fun CreatePersonRequest.toCommand() =
        CreatePerson(
                personId = PersonId(),
                name = Name(this.name),
                address = Address(this.address),
                cpf = Cpf(this.cpf),
                rg = Rg(this.rg)
        )

fun UpdatePersonRequest.toCommand(id: String) =
        UpdatePerson(
                personId = PersonId(id),
                name = Name(this.name),
                address = Address(this.address),
                cpf = Cpf(this.cpf),
                rg = Rg(this.rg)
        )