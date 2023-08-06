package br.com.springrest.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.springrest.exceptions.ResourceNotFoundException;
import br.com.springrest.model.Person;
import br.com.springrest.repositories.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {

	@Mock
	private PersonRepository repository;
	
	@InjectMocks
	private PersonServices services;
	
	private Person person0;
	
	@BeforeEach
	public void setup() {
		// Given / Arrange
		person0 = new Person("Leandro", "costa", "leandro@gmail.com.br", "uberlandia", "male");
	}
	

	@Test
	@DisplayName("JUnit test Given Person Object When Save Person then Return Person Object")
	void testGivenPersonObject_WhenSavePerson_thenReturnPersonObject() {
		// Given / Arrange
		given(repository.findByEmail(anyString())).willReturn(Optional.empty());
		given(repository.save(person0)).willReturn(person0);
		// When / Act
		Person savedPerson = services.create(person0);
		
		// Then / Assert
		assertNotNull(savedPerson);
		assertEquals("Leandro",savedPerson.getFirstName());
	}
	
	@Test
	@DisplayName("JUnit test Given Existing Email When Save Person then Throws Exception")
	void testGivenExistingEmail_WhenSavePerson_thenThrowsException() {
		// Given / Arrange
		given(repository.findByEmail(anyString())).willReturn(Optional.of(person0));

		// When / Act
		assertThrows(ResourceNotFoundException.class, () -> {
			services.create(person0);
		});
		
		// Then / Assert
		verify(repository, never()).save(any(Person.class));
	}
	
	@Test
	@DisplayName("JUnit test Given Persons List When FindAll Persons then Return Persons List")
	void testGivenPersonsList_WhenFindAllPersons_thenReturnPersonsList() {
		// Given / Arrange
		Person person1 = new Person("Leonardo", "costa", "leandro@gmail.com.br", "uberlandia", "male");
		
		given(repository.findAll()).willReturn(List.of(person0, person1));

		// When / Act
		List<Person> personsList = services.findAll();
		
		// Then / Assert
		assertNotNull(personsList);
		assertEquals(2, personsList.size());
	}

	@Test
	@DisplayName("JUnit test Given Empty Persons List When FindAll Persons then Return Empty Persons List")
	void testGivenEmptyPersonsList_WhenFindAllPersons_thenReturnEmptyPersonsList() {
		// Given / Arrange
		given(repository.findAll()).willReturn(Collections.emptyList());

		// When / Act
		List<Person> personsList = services.findAll();
		
		// Then / Assert
		assertTrue(personsList.isEmpty());
		assertEquals(0, personsList.size());
	}
	
	@Test
	@DisplayName("JUnit test Given PersonId When FindById then Return Person Object")
	void testGivenPersonId_WhenFindById_thenReturnPersonObject() {
		// Given / Arrange
		given(repository.findById(anyLong())).willReturn(Optional.of(person0));
		// When / Act
		Person savedPerson = services.findById(1l);
		
		// Then / Assert
		assertNotNull(savedPerson);
		assertEquals("Leandro",savedPerson.getFirstName());
	}
}
