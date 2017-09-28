package br.com.zup.cadastropessoas.web.controller

import br.com.zup.cadastropessoas.api.PersonApi
import br.com.zup.cadastropessoas.api.representation.PersonRepresentation
import br.com.zup.cadastropessoas.api.request.CreatePersonRequest
import br.com.zup.cadastropessoas.application.commands.br.com.zup.cadastropessoas.handler.PersonCommandHandler
import br.com.zup.cadastropessoas.web.util.toCommand
import br.com.zup.cadastropessoas.web.util.toRepresentation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController @Autowired constructor(private val commandHandler: PersonCommandHandler) : PersonApi {

    override fun create(@RequestBody request: CreatePersonRequest): ResponseEntity<PersonRepresentation> {

        val command = request.toCommand()

        val person = commandHandler.handler(command)

        return ResponseEntity(person.toRepresentation(), HttpStatus.CREATED)

    }

}