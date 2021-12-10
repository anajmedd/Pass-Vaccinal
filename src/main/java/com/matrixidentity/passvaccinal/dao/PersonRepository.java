package com.matrixidentity.passvaccinal.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matrixidentity.passvaccinal.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findByFirstNameLike(String firstName);
	List<Person> findByFirstNameAndLastNameLike(String firstName, String lastName);
	

}
