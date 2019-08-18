package com.github.ravisuthar.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

import java.util.List;

import com.github.ravisuthar.model.User;

@Client("/user") 
public interface UserControllerClient {


	@Get(value="/users", produces=MediaType.APPLICATION_JSON)
	public Single<List<User>> getAll();
	
	@Get(value="/user/{id}", produces=MediaType.APPLICATION_JSON)
	public User get(@PathVariable String id);
	
	
	@Post(value="/user", consumes=MediaType.APPLICATION_JSON)
	public void add(@Body User user);
	
	@Put(value="/user/{id}", consumes=MediaType.APPLICATION_JSON)
	public void update(@Body User user, @PathVariable String id);
	
	@Delete("/user/{id}")
	public void delete(@PathVariable String id);
	
}