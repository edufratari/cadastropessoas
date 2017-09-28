package br.com.zup.cadastropessoas.jdbc.repository

import br.com.zup.cadastropessoas.domain.Cpf
import br.com.zup.cadastropessoas.domain.Person
import br.com.zup.cadastropessoas.domain.PersonId
import br.com.zup.cadastropessoas.domain.repository.PersonRepository
import br.com.zup.cadastropessoas.jdbc.repository.extractor.PersonMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
open class JdbcPersonRepository @Autowired constructor(val jdbcTemplate: JdbcTemplate) : PersonRepository{

    companion object {
        val TABLE_NAME = "person"
        val ID_COLUMN = "id"
        val NAME_COLUMN = "name"
        val CPF_COLUMN = "cpf"
        val RG_COLUMN = "rg"
        val ADDRESS_COLUMN = "address"
        val CREATED_AT_COLUMN = "created_at"
        val UPDATED_AT = "updated_at"
    }

    override fun save(person: Person): Int {
        val sql = """
                    insert into $TABLE_NAME ($ID_COLUMN,$NAME_COLUMN, $CPF_COLUMN, $RG_COLUMN, $ADDRESS_COLUMN, $CREATED_AT_COLUMN)
                    values (?, ?, ?, ?, now())
                """.trimIndent()
        return jdbcTemplate.update(sql, person.id.value, person.name.value, person.cpf.value!!, person.rg.value, person.address.value)
    }

    override fun update(person: Person): Int {
        val sql = """
                    update $TABLE_NAME
                    set $NAME_COLUMN = ?,
                        $CPF_COLUMN = ?,
                        $RG_COLUMN = ?,
                        $ADDRESS_COLUMN = ?
                        $UPDATED_AT = now()
                    where $ID_COLUMN = ?

                """.trimIndent()
        return jdbcTemplate.update(sql, person.name.value, person.cpf.value!!, person.rg.value, person.address.value)
    }

    override fun delete(id: PersonId): Int {
        val sql = """
                    delete from $TABLE_NAME
                    where $ID_COLUMN = ?
                """.trimIndent()
        return jdbcTemplate.update(sql, id.value)
    }

    override fun find(id: PersonId): Person {
        val sql = """
                    select * from $TABLE_NAME
                    where $ID_COLUMN = ?
                """.trimIndent()
        return jdbcTemplate.queryForObject(sql, PersonMapper(), id.value)
    }

    override fun findCpf(cpf: Cpf): Person {
        val sql = """
                    select* from $TABLE_NAME
                    where $CPF_COLUMN = ?
                """.trimIndent()
        return jdbcTemplate.queryForObject(sql, PersonMapper(), cpf.value)
    }
}