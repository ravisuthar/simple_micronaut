package com.github.ravisuthar.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.coxautodev.graphql.tools.SchemaParser;
import com.github.ravisuthar.graphql.datafetcher.HelloDataFetcher;
import com.github.ravisuthar.graphql.datafetcher.UserDataFetcher;

@Factory
public class GraphQLFactory {

	@Inject
	private HelloDataFetcher helloDataFetcher;

	@Inject
	private UserDataFetcher userDataFetcher;

	@Bean
	@Singleton
	public GraphQL graphQL() {
		// https://www.graphql-java-kickstart.com/tools/schema-definition/

		GraphQLSchema graphQLSchema = SchemaParser.newParser()
				.file("classpath:resources/schema.graphqls")
				.resolvers(this.userDataFetcher, this.helloDataFetcher).build()
				.makeExecutableSchema();
		return GraphQL.newGraphQL(graphQLSchema).build();
	}
}