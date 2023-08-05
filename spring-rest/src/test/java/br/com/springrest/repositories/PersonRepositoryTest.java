package br.com.springrest.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.springrest.model.Person;

@DataJpaTest
public class PersonRepositoryTest {

	@Autowired
	private PersonRepositories repositories;
	
	@Test
	@DisplayName("Given Person Object When Save then Returns Saved Person")
	void testGivenPersonObject_WhenSave_thenReturnsSavedPerson() {
		// Given / Arrange
		Person person0 = new Person("Leandro", "costa", "leandro@gmail.com.br", "uberlandia", "male");
		
		// When / Act
		Person savedPerson = repositories.save(person0);
		
		// Then / Assert
		assertNotNull(savedPerson);
		assertTrue(savedPerson.getId() > 0);
	}
	
}
