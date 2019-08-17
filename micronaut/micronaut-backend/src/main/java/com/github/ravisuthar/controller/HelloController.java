package com.github.ravisuthar.controller;

import io.micronaut.http.annotation.Controller;

import io.micronaut.http.annotation.Get;





@Controller("/hello")

public class HelloController {



    @Get("/{name}")

    public String hello(String name) {

        return "Hello " + name + "!";

    }

}	