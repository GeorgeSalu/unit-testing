package br.com.springrest.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.springrest.model.Person;

@DataJpaTest
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository repository;
	
	@Test
	@DisplayName("Given Person Object When Save then Returns Saved Person")
	void testGivenPersonObject_WhenSave_thenReturnsSavedPerson() {
		// Given / Arrange
		Person person0 = new Person("Leandro", "costa", "leandro@gmail.com.br", "uberlandia", "male");
		
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
		Person person0 = new Person("Leandro", "costa", "leandro@gmail.com.br", "uberlandia", "male");
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
		Person person0 = new Person("Leandro", "costa", "leandro@gmail.com.br", "uberlandia", "male");
		
		repository.save(person0);
		
		// When / Act
		Person savedPerson = repository.findById(person0.getId()).get();
		
		// Then / Assert
		assertNotNull(savedPerson);
		assertEquals(person0.getId(), savedPerson.getId());
	}
	
}
