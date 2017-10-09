package br.com.cadastropessoas.jdbc.repository

import br.com.cadastropessoas.domain.*
import br.com.cadastropessoas.domain.repository.PersonRepository
import br.com.cadastropessoas.jdbc.repository.config.RepositoryBaseTest
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import kotlin.test.assertEquals

class JdbcPersonRepositoryTest : RepositoryBaseTest() {

    @Autowired
    private lateinit var personRepository: PersonRepository

    @Test
    fun savePersonSuccess() {
        val person = createNewPerson()
        val isSaved = personRepository.save(person)
        assertEquals(1, isSaved)
    }

    @Test
    fun updatePersonSuccess() {
        val person = createNewPerson()
        val isSaved = personRepository.save(person)
        assertEquals(1, isSaved)

        person.name.value = "Eduardo"

        val isUpdated = personRepository.update(person)
        assertEquals(1, isUpdated)

        val selected = personRepository.find(person.id)
        assertEquals(selected?.name?.value, person.name.value)
    }

    @Test
    fun delete(){
        val person = createNewPerson()
        val isSaved = personRepository.save(person)
        assertEquals(1, isSaved)

        val delete = personRepository.delete(person.id)
        assertEquals(1, delete)
    }

    @Test
    fun find(){
        val person = createNewPerson()
        val isSaved = personRepository.save(person)
        assertEquals(1, isSaved)

        val find = personRepository.find(person.id)
        assertEquals(person.id.value, find!!.id.value)
        assertEquals(person.name.value, find.name.value)

    }

    private fun createNewPerson() =
            Person(
                    id = PersonId(),
                    name = Name("Any Name Here"),
                    cpf = Cpf("cpf"),
                    rg = Rg("rg"),
                    address = Address("address")
            )
}