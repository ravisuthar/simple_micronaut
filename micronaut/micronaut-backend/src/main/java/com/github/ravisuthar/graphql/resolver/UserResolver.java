package com.github.ravisuthar.graphql.resolver;

import javax.inject.Inject;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.ravisuthar.model.User;
import com.github.ravisuthar.service.UserService;

public class UserResolver implements GraphQLQueryResolver {

	@Inject
	private UserService userService;

	public User getUser() {
		return this.userService.get();
	}
}
