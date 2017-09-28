package br.com.zup.cadastropessoas.application.commands.br.com.zup.cadastropessoas.handler

import br.com.zup.cadastropessoas.application.commands.*
import br.com.zup.cadastropessoas.domain.Cpf
import br.com.zup.cadastropessoas.domain.Person
import br.com.zup.cadastropessoas.domain.PersonId
import br.com.zup.cadastropessoas.domain.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import java.util.*


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

    fun handler(command: UpdatePerson): Person? {

        val person = getPerson(command.personId)

        person!!.update(repository)

        return person

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

    private fun getPerson(personId: PersonId): Person? {
        return Optional.ofNullable(repository.find(personId))
                .orElseThrow {
                    //TODO Criar sua própria exceção PersonNotFoundException
                    throw Exception()
                }
    }

    private fun getPerson(cpf: Cpf): Person? {
        return Optional.ofNullable(repository.findCpf(cpf))
                .orElseThrow {
                    //TODO Criar sua própria exceção PersonNotFoundException
                    throw Exception()
                }
    }

}