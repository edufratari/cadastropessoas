package br.com.cadastropessoas.web

import br.com.cadastropessoas.api.representation.PersonRepresentation
import br.com.cadastropessoas.api.request.CreatePersonRequest
import br.com.cadastropessoas.api.request.UpdatePersonRequest
import br.com.cadastropessoas.infraestructure.jsonToObject
import br.com.cadastropessoas.infraestructure.objectToJson
import br.com.cadastropessoas.web.config.ApplicationTestConfig
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@WebAppConfiguration
@SpringBootTest
@RunWith(SpringRunner::class)
@ContextConfiguration(classes = arrayOf(ApplicationTestConfig::class))
abstract class ControllerBaseTeste {

    @Autowired
    protected lateinit var context: WebApplicationContext

    protected lateinit var mockMvc: MockMvc

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build()
    }

    fun createPersonRequestSuccess() =
            CreatePersonRequest(
                    name = "Any name here",
                    address = "address",
                    cpf = "64118232430",
                    rg = "rg"
            )

    fun updatePersonRequestSuccess() =
            UpdatePersonRequest(
                    name = "Any name here updated",
                    address = "address updated",
                    cpf = "86778639407",
                    rg = "rg updated"
            )

    fun createPerson(): List<String?> {
        val person = createPersonRequestSuccess()
        val result = this.mockMvc.perform(MockMvcRequestBuilders.post("/persons")
                .content(person.objectToJson())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isCreated)
                .andReturn()
        return listOf(
                result.response.contentAsString.jsonToObject(PersonRepresentation::class.java).id,
                person.cpf
        )

    }

    fun deletePerson(id: String){
         this.mockMvc.perform(MockMvcRequestBuilders.delete("/persons/{personId}", id)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isNoContent)
                .andReturn()
    }
}