package br.com.cadastropessoas.web.util

import br.com.cadastropessoas.domain.Person
import br.com.cadastropessoas.web.representation.PersonRepresentation

fun Person.toRepresentation() =
        PersonRepresentation(
                address = this.address.value!!,
                rg = this.rg.value!!,
                cpf = this.cpf.value!!,
                name = this.name.value!!,
                id = this.id.value
        )