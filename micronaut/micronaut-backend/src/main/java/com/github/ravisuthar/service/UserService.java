package com.github.ravisuthar.service;

import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.ravisuthar.model.User;

@Singleton
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	public List<User> getAll(){
		return Arrays.asList(new User("1", "ABC", "abc@abc.abc"), new User("2", "xyz", "xyz@xyz.xyz"));
	}
	
	public User get(){
		return new User("1", "ABC", "abc@abc.abc");
	}

	public boolean addUser(String user) {
		LOGGER.info("User Added {}", user);
		return true;
	}
}
