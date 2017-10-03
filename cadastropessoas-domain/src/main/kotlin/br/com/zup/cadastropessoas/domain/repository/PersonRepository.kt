package br.com.zup.cadastropessoas.domain.repository

import br.com.zup.cadastropessoas.domain.Cpf
import br.com.zup.cadastropessoas.domain.Person
import br.com.zup.cadastropessoas.domain.PersonId

interface PersonRepository {

    fun save(person: Person): Int

    fun update(person: Person): Int

    fun delete(id: PersonId): Int

    fun find(id: PersonId): Person?

    fun findCpf(cpf: Cpf): Person?
}