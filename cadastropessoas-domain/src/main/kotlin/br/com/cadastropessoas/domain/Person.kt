package br.com.cadastropessoas.domain

import br.com.caelum.stella.ValidationMessage
import br.com.caelum.stella.validation.CPFValidator
import br.com.cadastropessoas.domain.repository.PersonRepository
import java.lang.RuntimeException

class Person(val id: PersonId, val name: Name, val cpf: Cpf, val rg: Rg, val address: Address){

    fun create(repository: PersonRepository) {
        validaCpf(this.cpf!!.value!!)
        verifyCpf(repository)
        repository.save(this)
    }

    fun update(repository: PersonRepository, oldPerson: Person) {
        validaCpf(this.cpf!!.value!!)
        verifyCpf(repository, oldPerson.cpf)
        repository.update(this)
    }

    private fun verifyCpf(repository: PersonRepository, oldCpf: Cpf){
        if(oldCpf.value != this.cpf.value && repository.findCpf(this.cpf) != null){
            throw RuntimeException("Exists person cpf")
        }
    }

    private fun verifyCpf(repository: PersonRepository){
        if(repository.findCpf(this.cpf) != null){
            throw RuntimeException("Exists person cpf")
        }
    }

    fun delete(repository: PersonRepository) {
        repository.delete(this.id)
    }

    private fun validaCpf(cpf: String){
        val messages: List<ValidationMessage> = CPFValidator().invalidMessagesFor(cpf)

        for (error in messages) {
            System.out.println(error.getMessage())
        }
        return CPFValidator().assertValid(cpf)
    }
}