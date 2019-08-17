package com.github.ravisuthar.graphql.datafetcher;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import javax.inject.Singleton;


@Singleton
public class HelloDataFetcher implements DataFetcher<String> {

    @Override
    public String get(DataFetchingEnvironment env) {
        String name = env.getArgument("name");
        if (name == null || name.trim().length() == 0) {
            name = "World";
        }
        return String.format("Hello %s!", name);
    }
}