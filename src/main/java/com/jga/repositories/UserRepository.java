package com.jga.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jga.models.User;

public interface UserRepository
 extends CrudRepository<User, Integer>{
	@Query("SELECT user FROM User user WHERE user.username=:u")
	public Iterable<User> findUserByUsername(@Param("u") String usrnm);
	
	@Query("SELECT u FROM User u WHERE u.username=:username AND u.password=:password")
	public Iterable<User> findUserByCredentials(
			@Param("username") String username, 
			@Param("password") String password);
}
