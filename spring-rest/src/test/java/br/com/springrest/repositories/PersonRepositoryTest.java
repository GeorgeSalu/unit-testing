package br.com.springrest.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.springrest.integrationtest.testcontainers.AbstractIntegrationTest;
import br.com.springrest.model.Person;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonRepositoryTest extends AbstractIntegrationTest {

	@Autowired
	private PersonRepository repository;
	
	private Person person0;
	
	@BeforeEach
	public void setup() {
		// Given / Arrange
		person0 = new Person("Leandro", "costa", "leandro@gmail.com.br", "uberlandia", "male");
	}
	
	@Test
	@DisplayName("Given Person Object When Save then Returns Saved Person")
	void testGivenPersonObject_WhenSave_thenReturnsSavedPerson() {
		
		
		// When / Act
		Person savedPerson = repository.save(person0);
		
		// Then / Assert
		assertNotNull(savedPerson);
		assertTrue(savedPerson.getId() > 0);
	}
	
	@Test
	@DisplayName("Given Person List When FindAll then Returns Person List")
	void testGivenPersonList_WhenFindAll_thenReturnsPersonList() {
		// Given / Arrange
		Person person1 = new Person("Leonardo", "costa", "leandro@gmail.com.br", "uberlandia", "male");
		
		repository.save(person0);
		repository.save(person1);
		
		// When / Act
		List<Person> personList = repository.findAll();
		
		// Then / Assert
		assertNotNull(personList);
		assertEquals(2, personList.size());
	}
	
	@Test
	@DisplayName("Given Person Object When FindByID then Returns Person Object")
	void testGivenPersonObject_WhenFindByID_thenReturnsPersonObject() {
		// Given / Arrange
		
		repository.save(person0);
		
		// When / Act
		Person savedPerson = repository.findById(person0.getId()).get();
		
		// Then / Assert
		assertNotNull(savedPerson);
		assertEquals(person0.getId(), savedPerson.getId());
	}
	
	@Test
	@DisplayName("Given Person Object When Find By Email then Returns Person Object")
	void testGivenPersonObject_WhenFindByEmail_thenReturnsPersonObject() {
		// Given / Arrange
		
		repository.save(person0);
		
		// When / Act
		Person savedPerson = repository.findByEmail(person0.getEmail()).get();
		
		// Then / Assert
		assertNotNull(savedPerson);
		assertEquals(person0.getId(), savedPerson.getId());
	}
	
	@Test
	@DisplayName("Given Person Object When Update Person then Return Update Person Object")
	void testGivenPersonObject_WhenUpdatePerson_thenReturnUpdatePersonObject() {
		// Given / Arrange
		
		repository.save(person0);
		
		// When / Act
		Person savedPerson = repository.findById(person0.getId()).get();
		savedPerson.setFirstName("Leonardo");
		savedPerson.setEmail("leonardo@gmail.com.br");
		
		
		Person updatedPerson = repository.save(savedPerson);
		// Then / Assert
		assertNotNull(updatedPerson);
		assertEquals("Leonardo", updatedPerson.getFirstName());
	}
	
	@Test
	@DisplayName("Given Person Object When Delete then Remove Person")
	void testGivenPersonObject_WhenDelete_thenRemovePerson() {
		// Given / Arrange
		
		repository.save(person0);
		
		// When / Act
		repository.deleteById(person0.getId());
		
		Optional<Person> personOptional = repository.findById(person0.getId());
		
		// Then / Assert
		assertTrue(personOptional.isEmpty());
	}
	
	@Test
	@DisplayName("Given FirstName And LastName When Find JPQL then Returns Person Object")
	void testGivenFirstNameAndLastName_WhenFindJPQL_thenReturnsPersonObject() {
		// Given / Arrange
		
		repository.save(person0);
		
		// When / Act
		Person savedPerson = repository.findByJPQL("Leandro", "costa");
		
		// Then / Assert
		assertNotNull(savedPerson);
		assertEquals("Leandro", savedPerson.getFirstName());
		assertEquals(person0.getId(), savedPerson.getId());
	}
	
	@Test
	@DisplayName("Given FirstName And LastName When Find JPQL Named Parameters then Returns Person Object")
	void testGivenFirstNameAndLastName_WhenFindJPQLNamedParameters_thenReturnsPersonObject() {
		// Given / Arrange
		
		repository.save(person0);
		
		// When / Act
		Person savedPerson = repository.findByJPQLnamedParameters("Leandro", "costa");
		
		// Then / Assert
		assertNotNull(savedPerson);
		assertEquals("Leandro", savedPerson.getFirstName());
		assertEquals(person0.getId(), savedPerson.getId());
	}
	
	@Test
	@DisplayName("Given FirstName And LastName When Find by SQL then Returns Person Object")
	void testGivenFirstNameAndLastName_WhenFindBySQL_thenReturnsPersonObject() {
		// Given / Arrange
		
		repository.save(person0);
		
		// When / Act
		Person savedPerson = repository.findBySQL("Leandro", "costa");
		
		// Then / Assert
		assertNotNull(savedPerson);
		assertEquals("Leandro", savedPerson.getFirstName());
		assertEquals(person0.getId(), savedPerson.getId());
	}
	
	@Test
	@DisplayName("Given FirstName And LastName When Find by SQL with named parameters then Returns Person Object")
	void testGivenFirstNameAndLastName_WhenFindBySQLWithNamedParameters_thenReturnsPersonObject() {
		// Given / Arrange
		
		repository.save(person0);
		
		// When / Act
		Person savedPerson = repository.findByNativeSQLWithNamedParameters("Leandro", "costa");
		
		// Then / Assert
		assertNotNull(savedPerson);
		assertEquals("Leandro", savedPerson.getFirstName());
		assertEquals(person0.getId(), savedPerson.getId());
	}
	
}
