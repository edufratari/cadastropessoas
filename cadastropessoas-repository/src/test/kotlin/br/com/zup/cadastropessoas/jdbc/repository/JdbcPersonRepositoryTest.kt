package br.com.zup.cadastropessoas.jdbc.repository

import br.com.zup.cadastropessoas.domain.*
import org.junit.Test

class JdbcPersonRepositoryTest {//: RepositoryBaseTest() {

//    @Autowired
//    private lateinit var personRepository: PersonRepository

    @Test
    fun savePersonSuccess() {
//        val person = creteNewPerson()
//        val isSaved = personRepository.save(person)
//        assertEquals(1, isSaved)
    }

    private fun creteNewPerson() =
            Person(
                    id = PersonId(),
                    name = Name("Any Name Here"),
                    cpf = Cpf("cpf"),
                    rg = Rg("rg"),
                    address = Address("address")
            )
}