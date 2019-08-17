package com.github.ravisuthar.graphql.datafetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.List;

import javax.inject.Inject;

import com.github.ravisuthar.model.User;
import com.github.ravisuthar.service.UserService;

public class UserDataFetcher implements DataFetcher<List<User>> {

	@Inject
	private UserService userService;

	@Override
	public List<User> get(DataFetchingEnvironment arg0) throws Exception {
		return this.userService.getAll();
	}
}
