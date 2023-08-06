package br.com.springrest.services;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springrest.exceptions.ResourceNotFoundException;
import br.com.springrest.model.Person;
import br.com.springrest.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repositorie;

	public List<Person> findAll() {
		return repositorie.findAll();
	}

	public Person findById(Long id) {
		
		logger.info("Finding one person!");
		
		return repositorie.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this is"));
	}
	
	public Person create(Person person) {

		logger.info("Creating one person!");
		
		Optional<Person> savedPerson = repositorie.findByEmail(person.getEmail());
		if(savedPerson.isPresent()) {
			throw new ResourceNotFoundException("Person already exist with given e-amil "+person.getEmail());
		}
		return repositorie.save(person);
	}
	
	public Person update(Person person) {
		
		logger.info("Updating one person!");
		var entity = repositorie.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this is"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repositorie.save(person);
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person!");
		
		var entity = repositorie.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this is"));
		repositorie.delete(entity);
	}
	
}
