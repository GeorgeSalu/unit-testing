package br.com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.model.Person;
import br.com.service.IPersonService;
import br.com.service.PersonService;

public class PersonServiceTest {

	@Test
	@DisplayName("When create a person with sucess should return a person object")
	void testCreatePerson_WhenSucess_ShouldReturnPersonObject() {
		// Given / Arrange
		IPersonService service = new PersonService();
		
		Person person = new Person("keith", "Moon", "kmoon@gmail.com", "uk", "male");
		
		// When / Act
		Person actual = service.createPerson(person);
		
		// Then / Assert
		assertNotNull(actual,() -> "the createPerson() should not have returned null");
		
	}
	
}
