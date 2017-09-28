package br.com.zup.cadastropessoas.web.controller

import br.com.zup.cadastropessoas.api.representation.PersonRepresentation
import br.com.zup.cadastropessoas.api.request.CreatePersonRequest
import br.com.zup.cadastropessoas.application.commands.br.com.zup.cadastropessoas.handler.PersonCommandHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

class PersonController @Autowired constructor(private val commandHandler: PersonCommandHandler) {

    fun create(@RequestBody request: CreatePersonRequest): ResponseEntity<PersonRepresentation> {

    }

}