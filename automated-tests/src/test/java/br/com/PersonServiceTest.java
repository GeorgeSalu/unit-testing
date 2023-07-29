package br.com;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.service.IPersonService;
import br.com.service.PersonService;

public class PersonServiceTest {

	@Test
	@DisplayName("When create a person with sucess should return a person object")
	void testCreatePerson_WhenSucess_ShouldReturnPersonObject() {
		// Given / Arrange
		IPersonService service = new PersonService();
		
		// When / Act
		
		// Then / Assert
		
	}
	
}
