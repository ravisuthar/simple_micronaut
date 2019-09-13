package com.github.ravisuthar.graphql.resolver.query;

import javax.inject.Inject;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.ravisuthar.model.User;
import com.github.ravisuthar.service.UserService;

public class UserQueryResolver implements GraphQLQueryResolver {

	@Inject
	private UserService userService;

	public User getUser() {
		return this.userService.get();
	}
}
