package br.com.zup.cadastropessoas.jdbc.repository.extractor

import br.com.zup.cadastropessoas.domain.*
import br.com.zup.cadastropessoas.jdbc.repository.JdbcPersonRepository
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class PersonMapper : RowMapper<Person> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Person {
        val id = rs.getString(JdbcPersonRepository.ID_COLUMN)
        val name = rs.getString(JdbcPersonRepository.NAME_COLUMN)
        val cpf = rs.getString(JdbcPersonRepository.CPF_COLUMN)
        val rg = rs.getString(JdbcPersonRepository.RG_COLUMN)
        val address = rs.getString(JdbcPersonRepository.ADDRESS_COLUMN)

        val person = Person(
                id = PersonId(id),
                name = Name(name),
                cpf = Cpf(cpf),
                rg = Rg(rg),
                address = Address(address)
        )
        return person
    }

}