package br.com.zup.cadastropessoas.domain

import br.com.caelum.stella.ValidationMessage
import br.com.caelum.stella.validation.CPFValidator
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

    fun validaCpf(cpf: String){
        val messages: List<ValidationMessage> = CPFValidator().invalidMessagesFor(cpf)

        for (error in messages) {
            System.out.println(error.getMessage())
        }
        return CPFValidator().assertValid(cpf)
    }
}