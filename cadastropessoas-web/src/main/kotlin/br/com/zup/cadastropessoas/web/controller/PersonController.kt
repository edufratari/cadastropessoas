package br.com.zup.cadastropessoas.web.controller

import br.com.zup.cadastropessoas.api.PersonApi
import br.com.zup.cadastropessoas.api.representation.PersonRepresentation
import br.com.zup.cadastropessoas.api.request.CreatePersonRequest
import br.com.zup.cadastropessoas.api.request.UpdatePersonRequest
import br.com.zup.cadastropessoas.application.commands.DeletePerson
import br.com.zup.cadastropessoas.application.commands.GetPerson
import br.com.zup.cadastropessoas.application.commands.GetPersonByCpf
import br.com.zup.cadastropessoas.application.commands.br.com.zup.cadastropessoas.handler.PersonCommandHandler
import br.com.zup.cadastropessoas.domain.Cpf
import br.com.zup.cadastropessoas.domain.PersonId
import br.com.zup.cadastropessoas.web.util.toCommand
import br.com.zup.cadastropessoas.web.util.toRepresentation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class PersonController @Autowired constructor(private val commandHandler: PersonCommandHandler) : PersonApi {

    override fun create(@RequestBody request: CreatePersonRequest): ResponseEntity<PersonRepresentation> {

        val command = request.toCommand()
        val person = commandHandler.handler(command)
        return ResponseEntity(person.toRepresentation(), HttpStatus.CREATED)

    }

    override fun update(@PathVariable("personId") personId: String, @RequestBody @Valid request: UpdatePersonRequest): ResponseEntity<Void>{

        val command = request.toCommand(personId)
        commandHandler.handler(command)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    override fun delete(@PathVariable("personId") personId: String): ResponseEntity<Void> {

        val command = DeletePerson(PersonId(personId))
        commandHandler.handler(command)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    override fun getPerson(@PathVariable("personId") personId: String): ResponseEntity<PersonRepresentation?> {

        val command = GetPerson(PersonId(personId))
        val person = commandHandler.handler(command)
        return ResponseEntity(person?.toRepresentation(), HttpStatus.OK)
    }

    override fun getPersonByCpf(@PathVariable("cpf") cpf: String): ResponseEntity<PersonRepresentation?> {
        val command = GetPersonByCpf(Cpf(cpf))
        val person = commandHandler.handler(command)
        return ResponseEntity(person?.toRepresentation(), HttpStatus.OK)

    }
}