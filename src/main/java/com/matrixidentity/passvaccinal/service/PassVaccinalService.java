package com.matrixidentity.passvaccinal.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.matrixidentity.passvaccinal.dao.PersonRepository;
import com.matrixidentity.passvaccinal.dto.CheckPassRequestDto;
import com.matrixidentity.passvaccinal.dto.CheckPassResponseDto;
import com.matrixidentity.passvaccinal.entities.Person;

@Service                                                                
public class PassVaccinalService {
	
	@Autowired
	public PersonRepository personRepository;
	
	public CheckPassResponseDto checkPass(CheckPassRequestDto requestDto) {
		

		
		ArrayList<Person> persons = (ArrayList<Person>) personRepository.findByFirstNameLike(requestDto.firstName);
		
		if(persons==null || persons.size()==0) {
			Person person = new Person();
			person.setFirstName(requestDto.firstName);
			person.setLastName(requestDto.lastName);
			personRepository.save(person);
		}
		
		return null;
	}
	public Person afficherPass(@RequestBody CheckPassRequestDto requestDto) {
		ArrayList<Person> persons = (ArrayList<Person>) personRepository.findByFirstNameAndLastNameLike(requestDto.firstName,requestDto.lastName);
		if (persons==null || persons.size()==0) {
			return null;
		} else {
			Person person = new Person();
			person.setFirstName(requestDto.firstName);
			person.setLastName(requestDto.lastName);
			person.setAdress(persons.get(0).getAdress());
			person.setId(persons.get(0).getId());
			person.setBirthday(persons.get(0).getBirthday());
			return person;
			}
		
	}
	
}
