package br.com.zup.cadastropessoas.domain

import br.com.zup.cadastropessoas.domain.repository.PersonRepository

class Person(val id: PersonId, val name: Name, val cpf: Cpf, val rg: Rg, val address: Address){

    fun create(repository: PersonRepository) {
        repository.save(this)
    }

    fun update(repository: PersonRepository) {
        repository.update(this)
    }

    fun delete(repository: PersonRepository) {
        repository.delete(this.id)
    }

}