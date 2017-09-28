package br.com.zup.cadastropessoas.jdbc.repository.config

import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
@ContextConfiguration(classes = arrayOf(RepositoryTestConfig::class))
abstract class RepositoryBaseTest
