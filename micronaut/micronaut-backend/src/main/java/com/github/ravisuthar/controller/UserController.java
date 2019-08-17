package com.github.ravisuthar.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

import java.util.Arrays;
import java.util.List;

import com.github.ravisuthar.model.User;



@Controller("/user")
public class UserController {

	
	@Get(value="/users", processes=MediaType.APPLICATION_JSON)
	public List<User> getAll(){
		return Arrays.asList(new User("1", "ABC", "abc@abc.abc"), new User("2", "xyz", "xyz@xyz.xyz"));
	}
	
	@Get(value="/user/{id}", processes=MediaType.APPLICATION_JSON)
	public User get(@PathVariable String id){
		return new User("1", "ABC", "abc@abc.abc");
	}
	
	
	@Post(value="/user", consumes=MediaType.APPLICATION_JSON)
	public void add(@Body User user){
		System.out.println("added ");
	}
	
	@Put(value="/user/{id}", consumes=MediaType.APPLICATION_JSON)
	public void update(@Body User user, @PathVariable String id){
		System.out.println("updated ");
	}
	
	@Delete("/user/{id}")
	public void delete(@PathVariable String id){
		System.out.println("deleted ");
	}
	

}