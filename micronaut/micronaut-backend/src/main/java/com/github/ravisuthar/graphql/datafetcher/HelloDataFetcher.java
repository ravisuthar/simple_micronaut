package com.github.ravisuthar.graphql.datafetcher;
import javax.inject.Singleton;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;


@Singleton
public class HelloDataFetcher implements GraphQLQueryResolver {

    public String get(String evn) {
        String name = evn;
        if (name == null || name.trim().length() == 0) {
            name = "World";
        }
        return String.format("Hello %s!", name);
    }
}