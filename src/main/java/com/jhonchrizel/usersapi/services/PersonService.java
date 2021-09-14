package com.jhonchrizel.usersapi.services;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonchrizel.usersapi.entity.Person;
import com.jhonchrizel.usersapi.exceptions.UsersApiException;
import com.jhonchrizel.usersapi.repository.PersonRepository;

@Service
public class PersonService {
	
	private static final Logger log = LoggerFactory.getLogger(PersonService.class);
	
	@Autowired
	private PersonRepository personRepo;
	
	public List<Person> getAllPersons() throws UsersApiException{
		log.info(log.getClass() + ": user wants to get all the users without credentials");
		List<Person> persons = personRepo.findAll();
		if(persons.size() > 0) {
			log.info(log.getClass() + ": returning data found in db");
			return persons;
		}else{
			log.info(log.getClass() + ":  db is empty");
			throw new UsersApiException(UsersApiException.EMPTY_DATABASE);
		}
	}
	
	public List<Person> getPersonByFirstName(String firstName) throws UsersApiException{
		log.info(log.getClass() + ": user wants to get the persons with first name: " + firstName);
		List<Person> persons = personRepo.findByFirstName(firstName);
		if(persons.size() > 0) {
			log.info(log.getClass() + ": persons with first name: " + firstName + " found in db");
			return persons;
		}else{
			log.info(log.getClass() + ": persons with first name: " + firstName + " not found in db");
			throw new UsersApiException(UsersApiException.NO_RECORDS_FOUND + "'" + firstName + "'");
		}
		
	}
	
	public List<Person> getPersonByLastName(String lastName) throws UsersApiException{
		log.info(log.getClass() + ": user wants to get the persons with last name: " + lastName);
		List<Person> persons = personRepo.findByLastName(lastName);
		if(persons.size() > 0) {
			log.info(log.getClass() + ": persons with last name: " + lastName + " found in db");
			return persons;
		}else{
			log.info(log.getClass() + ": persons with last name: " + lastName + " not found in db");
			throw new UsersApiException(UsersApiException.NO_RECORDS_FOUND + "'" + lastName + "'");
		}
	}
	
	public List<Person> getPersonByGender(String gender) throws UsersApiException{
		log.info(log.getClass() + ": user wants to get the persons with gender: " + gender);
		List<Person> persons = personRepo.findByGender(gender);
		if(persons.size() > 0) {
			log.info(log.getClass() + ": persons with gender: " + gender + " found in db");
			return persons;
		}else{
			log.info(log.getClass() + ": persons with gender: " + gender + " not found in db");
			throw new UsersApiException(UsersApiException.NO_RECORDS_FOUND + "'" + gender + "'");
		}
	}
	
	public List<Person> getPersonByBirthday(LocalDate birthday) throws UsersApiException{
		log.info(log.getClass() + ": user wants to get the persons with birthday: " + birthday);
		List<Person> persons = personRepo.findByBirthday(birthday);
		if(persons.size() > 0) {
			log.info(log.getClass() + ": persons with birthday: " + birthday + " found in db");
			return persons;
		}else{
			log.info(log.getClass() + ": persons with birthday: " + birthday + " not found in db");
			throw new UsersApiException(UsersApiException.NO_RECORDS_FOUND + "'" + birthday + "'");
		}
	}

}
