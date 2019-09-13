package com.github.ravisuthar.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.coxautodev.graphql.tools.SchemaParser;
import com.github.ravisuthar.graphql.resolver.mutation.AddUserMutationResolver;
import com.github.ravisuthar.graphql.resolver.query.HelloQueryResolver;
import com.github.ravisuthar.graphql.resolver.query.UserQueryResolver;

@Factory
public class GraphQLFactory {

	@Inject
	private HelloQueryResolver helloDataQueryResolver;

	@Inject
	private UserQueryResolver userQueryResolver;

	@Inject
	private AddUserMutationResolver addUserMutationResolver;
	
	@Bean
	@Singleton
	public GraphQL graphQL() {
		// https://www.graphql-java-kickstart.com/tools/schema-definition/
		GraphQLSchema graphQLSchema = SchemaParser.newParser()
				.file("schema.graphqls")
				.resolvers(this.userQueryResolver, 
						this.helloDataQueryResolver,
						this.addUserMutationResolver)
				.build()
				.makeExecutableSchema();
		return GraphQL.newGraphQL(graphQLSchema).build();
	}
}