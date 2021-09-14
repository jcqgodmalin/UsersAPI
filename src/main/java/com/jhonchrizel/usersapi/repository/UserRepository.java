package com.jhonchrizel.usersapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonchrizel.usersapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmail(String email);
	
}
