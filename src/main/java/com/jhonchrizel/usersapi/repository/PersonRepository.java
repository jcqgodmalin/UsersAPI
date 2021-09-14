package com.jhonchrizel.usersapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonchrizel.usersapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {

	public List<Person> findByGender(String gender);
	public List<Person> findByLastName(String lastName);
	public List<Person> findByFirstName(String firstName);
	public List<Person> findByBirthday(LocalDate birthday);
	
}
