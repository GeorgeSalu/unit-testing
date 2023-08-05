package br.com.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springrest.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
