package com.github.ravisuthar.service;

import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import com.github.ravisuthar.model.User;

@Singleton
public class UserService {

	public List<User> getAll(){
		return Arrays.asList(new User("1", "ABC", "abc@abc.abc"), new User("2", "xyz", "xyz@xyz.xyz"));
	}
	
	public User get(){
		return new User("1", "ABC", "abc@abc.abc");
	}
}
