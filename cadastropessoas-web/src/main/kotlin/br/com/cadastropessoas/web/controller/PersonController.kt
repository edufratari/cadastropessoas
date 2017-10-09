package br.com.cadastropessoas.web.controller

import br.com.cadastropessoas.application.commands.DeletePerson
import br.com.cadastropessoas.application.commands.GetPerson
import br.com.cadastropessoas.application.commands.GetPersonByCpf
import br.com.cadastropessoas.application.commands.handler.PersonCommandHandler
import br.com.cadastropessoas.domain.Cpf
import br.com.cadastropessoas.domain.PersonId
import br.com.cadastropessoas.web.representation.PersonRepresentation
import br.com.cadastropessoas.web.request.CreatePersonRequest
import br.com.cadastropessoas.web.request.UpdatePersonRequest
import br.com.cadastropessoas.web.util.toCommand
import br.com.cadastropessoas.web.util.toRepresentation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/persons")
class PersonController @Autowired constructor(private val commandHandler: PersonCommandHandler) {

    @PostMapping(consumes = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun create(@RequestBody request: CreatePersonRequest): ResponseEntity<PersonRepresentation> {

        val command = request.toCommand()
        val person = commandHandler.handler(command)
        return ResponseEntity(person.toRepresentation(), HttpStatus.CREATED)

    }

    @PutMapping("/{personId}", consumes = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun update(@PathVariable("personId") personId: String, @RequestBody @Valid request: UpdatePersonRequest): ResponseEntity<Void> {

        val command = request.toCommand(personId)
        commandHandler.handler(command)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping("/{personId}")
    fun delete(@PathVariable("personId") personId: String): ResponseEntity<Void> {

        val command = DeletePerson(PersonId(personId))
        commandHandler.handler(command)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/{personId}")
    fun getPerson(@PathVariable("personId") personId: String): ResponseEntity<PersonRepresentation?> {

        val command = GetPerson(PersonId(personId))
        val person = commandHandler.handler(command)
        return ResponseEntity(person?.toRepresentation(), HttpStatus.OK)
    }

    @GetMapping("/{cpf}/cpf")
    fun getPersonByCpf(@PathVariable("cpf") cpf: String): ResponseEntity<PersonRepresentation?> {
        val command = GetPersonByCpf(Cpf(cpf))
        val person = commandHandler.handler(command)
        return ResponseEntity(person?.toRepresentation(), HttpStatus.OK)
    }

}