package com.github.ravisuthar.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.ravisuthar.model.User;

@Controller("/user")
@Validated
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Operation(summary = "Getting list of Users",
            description = "A list of users will be retured"
    )
    @ApiResponse(
            content = @Content(mediaType = "application/json",
                    schema = @Schema(type="string"))
    )
    @ApiResponse(responseCode = "400", description = "Invalid Name Supplied")
    @ApiResponse(responseCode = "404", description = "Users not found")
    @Tag(name = "greeting")
	@Get(value="/users", produces=MediaType.APPLICATION_JSON)
	public Single<List<User>> getAll(){
		return Single.just(Arrays.asList(new User("1", "ABC", "abc@abc.abc"), new User("2", "xyz", "xyz@xyz.xyz")));
	}
	
	@Get(value="/user/{id}", produces=MediaType.APPLICATION_JSON)
	public User get(@PathVariable String id){
		return new User("1", "ABC", "abc@abc.abc");
	}
	
	
	@Post(value="/user", consumes=MediaType.APPLICATION_JSON)
	public void add(@Body @Valid User user){
		LOGGER.info("added ");
	}
	
	@Put(value="/user/{id}", consumes=MediaType.APPLICATION_JSON)
	public void update(@Body @Valid User user, @PathVariable String id){
		LOGGER.info("updated ");
	}
	
	@Delete("/user/{id}")
	public void delete(@PathVariable String id){
		LOGGER.info("deleted ");
	}
	

}