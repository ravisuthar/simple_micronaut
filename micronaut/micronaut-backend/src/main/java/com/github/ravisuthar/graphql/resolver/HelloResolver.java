package com.github.ravisuthar.graphql.resolver;
import javax.inject.Singleton;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;


@Singleton
public class HelloResolver implements GraphQLQueryResolver {

    public String getHello(String evn) {
        String name = evn;
        if (name == null || name.trim().length() == 0) {
            name = "World";
        }
        return String.format("Hello %s!", name);
    }
}