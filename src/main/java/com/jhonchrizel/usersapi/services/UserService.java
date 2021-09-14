package com.jhonchrizel.usersapi.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonchrizel.usersapi.entity.User;
import com.jhonchrizel.usersapi.exceptions.UsersApiException;
import com.jhonchrizel.usersapi.repository.UserRepository;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	
	@Autowired
	private UserRepository userRepo;
	
	
	public List<User> getAllUsers() throws UsersApiException{
		log.info(log.getClass() + ": user wants to get all the users with credentials");
		List<User> users = userRepo.findAll();
		if(users.size() > 0) {
			log.info(log.getClass() + ": returning data found in db");
			return users;
		}else{
			log.info(log.getClass() + ":  db is empty");
			throw new UsersApiException(UsersApiException.EMPTY_DATABASE);
		}
	}
	
	public User getUserByEmail(String email) throws UsersApiException {
		log.info(log.getClass() + ": user wants to get the user with an email " + email);
		User user = userRepo.findByEmail(email);
		if(!(user == null)) {
			log.info(log.getClass() + ": user with email: " + email + " found in db");
			return user;
		}else{
			log.info(log.getClass() + ": user with email: " + email + " not found in db");
			throw new UsersApiException(UsersApiException.NO_RECORDS_FOUND + "'" + email + "'");
		}
	}
	
	
}
