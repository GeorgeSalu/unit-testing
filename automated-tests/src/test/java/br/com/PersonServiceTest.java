package br.com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.model.Person;
import br.com.service.IPersonService;
import br.com.service.PersonService;

public class PersonServiceTest {

	Person person;
	
	@BeforeEach
	void setup() {
		person = new Person("keith", "Moon", "kmoon@gmail.com", "uk", "male");
	}
	
	@Test
	@DisplayName("When create a person with sucess should return a person object")
	void testCreatePerson_WhenSucess_ShouldReturnPersonObject() {
		// Given / Arrange
		IPersonService service = new PersonService();
		
		// When / Act
		Person actual = service.createPerson(person);
		
		// Then / Assert
		assertNotNull(actual,() -> "the createPerson() should not have returned null");
	}

	@Test
	@DisplayName("When create a person with sucess should contains valid field in returned person object")
	void testCreatePerson_WhenSucess_ShouldContainsFirstNameInReturnedPersonObject() {
		// Given / Arrange
		IPersonService service = new PersonService();
		
		// When / Act
		Person actual = service.createPerson(person);
		
		// Then / Assert
		assertNotNull(person.getId(), () -> "person id is missing");
		assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The firstName is diferrent");
		assertEquals(person.getLastName(), actual.getLastName(), () -> "The lastName is diferrent");
		assertEquals(person.getAddress(), actual.getAddress(), () -> "The Address is diferrent");
		assertEquals(person.getGender(), actual.getGender(), () -> "The Gender is diferrent");
		assertEquals(person.getEmail(), actual.getEmail(), () -> "The email is diferrent");
	}

	
	@Test
	@DisplayName("When create a person with null email should should throw exception")
	void testCreatePerson_WithNullEmail_SouldThrowIllegalArgumentException() {
		// Given / Arrange
		IPersonService service = new PersonService();
		person.setEmail(null);
		
		var expectedMessage = "the person email is null or empty";
		
		// When / Act

		// Then / Assert
		
		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class, 
				() -> service.createPerson(person),
				() -> "empty email should have cause an illegalArgumentException"
		);
		
		assertEquals(expectedMessage, exception.getMessage(), () -> "Exception error messagem incorrect");
	}
	
}
