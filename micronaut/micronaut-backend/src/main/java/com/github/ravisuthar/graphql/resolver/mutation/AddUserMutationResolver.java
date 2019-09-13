package com.github.ravisuthar.graphql.resolver.mutation;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.github.ravisuthar.model.User;
import com.github.ravisuthar.service.UserService;

@Singleton
public class AddUserMutationResolver implements GraphQLMutationResolver{

	@Inject
	private UserService userService;

	public boolean addUser(String user) {
		return this.userService.addUser(user);
	}
	
}
