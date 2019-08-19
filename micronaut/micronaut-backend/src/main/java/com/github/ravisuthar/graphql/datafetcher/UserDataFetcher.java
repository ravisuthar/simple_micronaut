package com.github.ravisuthar.graphql.datafetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import javax.inject.Inject;

import com.github.ravisuthar.model.User;
import com.github.ravisuthar.service.UserService;

public class UserDataFetcher implements DataFetcher<User> {

	@Inject
	private UserService userService;

	@Override
	public User get(DataFetchingEnvironment arg0) throws Exception {
		return this.userService.get();
	}
}
