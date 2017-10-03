package br.com.zup.cadastropessoas.api

import br.com.zup.cadastropessoas.api.representation.PersonRepresentation
import br.com.zup.cadastropessoas.api.request.CreatePersonRequest
import br.com.zup.cadastropessoas.api.request.UpdatePersonRequest
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/person")
interface   PersonApi {

    @PostMapping(consumes = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun create(@RequestBody request: CreatePersonRequest): ResponseEntity<PersonRepresentation>

    @PutMapping("/{personId}", consumes = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun update(@PathVariable("personId") personId: String, @RequestBody @Valid request: UpdatePersonRequest): ResponseEntity<Void>

    @DeleteMapping("/{personId}")
    fun delete(@PathVariable("personId") personId: String) : ResponseEntity<Void>

    @GetMapping("/{personId}")
    fun getPerson(@PathVariable("personId") personId: String): ResponseEntity<PersonRepresentation?>

    @GetMapping("/{cpf}/cpf")
    fun getPersonByCpf(@PathVariable("cpf") cpf: String): ResponseEntity<PersonRepresentation?>
}