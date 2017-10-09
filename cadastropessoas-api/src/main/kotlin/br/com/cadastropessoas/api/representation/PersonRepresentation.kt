package br.com.cadastropessoas.api.representation

data class PersonRepresentation(
        val id: String,
        val name: String,
        val cpf: String,
        val address: String,
        val rg: String)