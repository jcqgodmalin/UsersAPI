package com.jhonchrizel.usersapi.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jhonchrizel.usersapi.entity.Person;
import com.jhonchrizel.usersapi.entity.User;
import com.jhonchrizel.usersapi.exceptions.UsersApiException;
import com.jhonchrizel.usersapi.services.PersonService;
import com.jhonchrizel.usersapi.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class GetControllers {
	
	@Autowired
	private UserService userService;
	@Autowired
	private PersonService personService;

	@GetMapping("/")
	public String home(){
		return "Hello World";
	}

	@GetMapping("/users")
	public List<User> getUsersWithCredentials(@RequestParam(value = "pkey", required = false) String pkey){
		String privateKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCcI";

		if(pkey.contentEquals(privateKey)){
			try {
				return userService.getAllUsers();
			}catch(UsersApiException e){
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
			}
		}else{
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Sorry, you are not allowed to get the users with credentials list");
		}
	}

	@GetMapping("/persons")
	public List<Person> getUsers() {
		try {
			return personService.getAllPersons();
		}catch(UsersApiException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}
	
	@GetMapping("/user/{email}")
	public User getUserByEmail(
			@PathVariable(value="email") String email) {
		try {
			return userService.getUserByEmail(email);
		}catch(UsersApiException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/users/gender/{gender}")
	public List<Person> getUsersByGender(
			@PathVariable(value="gender") String gender) { 
		try {
			return personService.getPersonByGender(gender);
		}catch(UsersApiException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/users/birthday/{birthday}")
	public List<Person> getUsersByBirthday(
			@PathVariable(value="birthday") String birthday){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			return personService.getPersonByBirthday(LocalDate.parse(birthday,formatter));
		}catch(UsersApiException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/users/first-name/{firstName}")
	public List<Person> getUsersByFirstName(
			@PathVariable(value="firstName") String firstName){
		try {
			return personService.getPersonByFirstName(firstName);
		}catch(UsersApiException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/users/last-name/{lastName}")
	public List<Person> getUsersByLastName(
			@PathVariable(value="lastName") String lastName){
		try {
			return personService.getPersonByLastName(lastName);
		}catch(UsersApiException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
