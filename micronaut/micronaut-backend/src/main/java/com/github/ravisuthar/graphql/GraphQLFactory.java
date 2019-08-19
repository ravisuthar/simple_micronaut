package com.github.ravisuthar.graphql;

import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.core.io.ResourceResolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

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
	public GraphQL graphQL(ResourceResolver resourceResolver) {

		SchemaParser schemaParser = new SchemaParser();
		SchemaGenerator schemaGenerator = new SchemaGenerator();

		// Parse the schema.
		TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();
		typeRegistry.merge(schemaParser.parse(new BufferedReader(
				new InputStreamReader(resourceResolver.getResourceAsStream(
						"classpath:schema.graphqls").get()))));

		Map<String, DataFetcher> dataFetchersMap=new HashMap<>();
		dataFetchersMap.put("hello", this.helloDataFetcher);
		dataFetchersMap.put("user", this.userDataFetcher);
		
		// Create the runtime wiring.
		RuntimeWiring runtimeWiring = RuntimeWiring
				.newRuntimeWiring()
				.type("Query",typeWiring -> typeWiring.dataFetchers(dataFetchersMap))
				.build();

		// Create the executable schema.
		GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(
				typeRegistry, runtimeWiring);
		

		// Return the GraphQL bean.
		return GraphQL.newGraphQL(graphQLSchema).build();
	}
}