package com.github.ravisuthar.graphql.datafetcher;

import javax.inject.Inject;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.ravisuthar.model.User;
import com.github.ravisuthar.service.UserService;

public class UserDataFetcher implements GraphQLQueryResolver {

	@Inject
	private UserService userService;

	public User get() {
		return this.userService.get();
	}
}
