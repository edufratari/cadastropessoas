package br.com.cadastropessoas.web.controller

import br.com.cadastropessoas.infraestructure.jsonToObject
import br.com.cadastropessoas.infraestructure.objectToJson
import br.com.cadastropessoas.web.ControllerBaseTeste
import br.com.cadastropessoas.web.representation.PersonRepresentation
import org.junit.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class PersonControllerTest : ControllerBaseTeste() {

    @Test
    fun createPersonSuccess() {
        val person = createPersonRequestSuccess()
        val result = this.mockMvc.perform(MockMvcRequestBuilders.post("/persons")
                .content(person.objectToJson())
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isCreated)
                .andReturn()
        val personIdToBeDeleted = result.response.contentAsString.jsonToObject(PersonRepresentation::class.java).id
        deletePerson(personIdToBeDeleted)
    }

    @Test
    fun updatePersonSuccess() {
        val personId = createPerson()[0]
        val personToBeUpdated = updatePersonRequestSuccess()
        this.mockMvc.perform(MockMvcRequestBuilders.put("/persons/{personId}", personId)
                .content(personToBeUpdated.objectToJson())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isNoContent)
        deletePerson(personId!!)
    }

    @Test
    fun deletePersonSuccess() {
        val personId = createPerson()[0]
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/persons/{personId}", personId))
                .andExpect(MockMvcResultMatchers.status().isNoContent)
    }

    @Test
    fun findPersonByCpfSuccess() {
        val result = createPerson()
        this.mockMvc.perform(MockMvcRequestBuilders.get("/persons/{cpf}/cpf", result[1]))
                .andExpect(MockMvcResultMatchers.status().isOk)
        deletePerson(result[0]!!)
    }

    @Test
    fun findPersonByIdSuccess() {
        val personId = createPerson()[0]
        this.mockMvc.perform(MockMvcRequestBuilders.get("/persons/{personId}", personId))
                .andExpect(MockMvcResultMatchers.status().isOk)
        deletePerson(personId!!)
    }

    @Test
    fun findAllPersons() {
        val personId = createPerson()[0]
        this.mockMvc.perform(MockMvcRequestBuilders.get("/persons"))
        deletePerson(personId!!)
    }
}