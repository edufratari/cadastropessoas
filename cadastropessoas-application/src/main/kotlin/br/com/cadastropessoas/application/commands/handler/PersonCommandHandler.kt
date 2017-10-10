package br.com.cadastropessoas.application.commands.handler

import br.com.cadastropessoas.application.command.exception.PersonNotFoundException
import br.com.cadastropessoas.application.commands.*
import br.com.cadastropessoas.domain.Cpf
import br.com.cadastropessoas.domain.Person
import br.com.cadastropessoas.domain.PersonId
import br.com.cadastropessoas.domain.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
open class PersonCommandHandler @Autowired constructor(private val repository: PersonRepository) {

    fun handler(command: CreatePerson): Person {

        val person = Person(
                id = command.personId,
                name = command.name,
                cpf = command.cpf,
                rg = command.rg,
                address = command.address
        )

        person.create(repository)
        return person
    }

    fun handler(command: UpdatePerson): Person {

        val person = getPerson(command.personId)

        val newPerson = Person(
                id = command.personId,
                name = command.name,
                cpf = command.cpf,
                rg = command.rg,
                address = command.address
        )

        newPerson.update(repository, person)

        return newPerson

    }

    fun handler(command: DeletePerson): Person? {

        val person = getPerson(command.personId)

        person!!.delete(repository)
        return person

    }

    fun handler(command: GetPerson): Person? {

        val person = getPerson(command.personId)

        return person
    }

    fun handler(command: GetPersonByCpf): Person? {

        val person = getPerson(command.cpf)

        return person
    }

    private fun getPerson(personId: PersonId): Person {
        return Optional.ofNullable(repository.find(personId))
                .orElseThrow {
                    throw PersonNotFoundException("Person not found")
                }
    }

    private fun getPerson(cpf: Cpf): Person? {
        return Optional.ofNullable(repository.findCpf(cpf))
                .orElseThrow {
                    throw PersonNotFoundException("Person not found")
                }
    }

}