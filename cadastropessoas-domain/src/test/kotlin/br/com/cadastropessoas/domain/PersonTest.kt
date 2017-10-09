package br.com.cadastropessoas.domain

import br.com.cadastropessoas.domain.repository.PersonRepository
import br.com.caelum.stella.validation.InvalidStateException
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import org.mockito.Mockito

class PersonTest {

    var personRepository: PersonRepository = mock()

    @Test
    fun createPersonSuccess(){
        val person = createPerson()
        person.create(repository = personRepository)
        Mockito.verify(personRepository).save(person)
    }

    @Test(expected = InvalidStateException::class)
    fun failureCreatePerson(){
        val person = createPersonWithInvalidCPF()
        person.create(repository = personRepository)
    }

    @Test
    fun updatePersonSuccess(){
        val person = createPerson()
        person.create(repository = personRepository)
        Mockito.verify(personRepository).save(person)

        person.name.value = "Eduardo"

        person.update(repository = personRepository, oldPerson = person)
        Mockito.verify(personRepository).update(person)
    }

    @Test
    fun deletePersonSuccess(){
        val person = createPerson()
        person.delete(personRepository)
    }

    private fun createPerson() =
            Person(
                    id = PersonId(),
                    name = Name("Any Name Here"),
                    cpf = Cpf("48114584866"),
                    rg = Rg("rg"),
                    address = Address("address")
            )

    private fun createPersonWithInvalidCPF() =
            Person(
                    id = PersonId(),
                    name = Name("Any Name Here"),
                    cpf = Cpf("11122233344"),
                    rg = Rg("rg"),
                    address = Address("address")
            )

}