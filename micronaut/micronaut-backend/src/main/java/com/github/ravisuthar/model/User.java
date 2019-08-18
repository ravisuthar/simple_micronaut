package com.github.ravisuthar.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class User {

	@NotBlank
	private String id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;

	public User() {
		super();
	}

	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
