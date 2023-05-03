package br.com.teste.mockito.services

import br.com.teste.repository.PersonRepository
import br.com.teste.services.PersonService
import br.com.teste.unittests.mapper.mocks.MockPerson
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class PersonServiceTest {

    private lateinit var inoputObject: MockPerson

    @InjectMocks
    private lateinit var service: PersonService

    @Mock
    private lateinit var repository: PersonRepository


    @BeforeEach
    fun setUp() {
        inoputObject = MockPerson()
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun findAll() {
    }

    @Test
    fun findById() {
        val person = inoputObject.mockEntity(1)
        person.id = 1L

        `when`(repository.findById(1)).thenReturn(Optional.of(person))

        val result = service.findById(1)
        assertNotNull(result)
        assertNotNull(result.id)
        assertEquals(result.id, 1L)
    }

    @Test
    fun create() {

        val entity = inoputObject.mockEntity(1)
        val persisted = entity.copy()
        persisted.id = 1

        `when`(repository.save(entity)).thenReturn(persisted)

        val result = service.create(entity)
        assertNotNull(result)
        assertEquals(result.id, 1L)
    }

    @Test
    fun update() {
    }

    @Test
    fun delete() {
    }
}