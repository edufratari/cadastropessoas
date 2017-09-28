package br.com.zup.cadastropessoas.api

import br.com.zup.cadastropessoas.api.representation.PersonRepresentation
import br.com.zup.cadastropessoas.api.request.CreatePersonRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

interface PersonApi {

    fun create(@RequestBody request: CreatePersonRequest): ResponseEntity<PersonRepresentation>

    //fun update(@PathVariable("personId") personId: String, @RequestBody request: UpdatePersonRequest)
}