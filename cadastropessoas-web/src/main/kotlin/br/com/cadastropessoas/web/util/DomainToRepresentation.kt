package br.com.cadastropessoas.web.util

import br.com.cadastropessoas.api.representation.PersonRepresentation
import br.com.cadastropessoas.domain.Person

fun Person.toRepresentation() =
        PersonRepresentation(
                address = this.address.value!!,
                rg = this.rg.value!!,
                cpf = this.cpf.value!!,
                name = this.name.value!!,
                id = this.id.value
        )