package com.github.ravisuthar.controller;

import io.micronaut.core.version.annotation.Version;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("version")
public class VersionController {

	@Version("1") 
    @Get("/hello")
    String helloV1() {
        return "hello from version-1";
    }

    @Version("2") 
    @Get("/hello")
    String helloV2() {
        return "hello from version-2";
    }
    
    @Version("3") 
    @Get("/hello")
    String helloV3() {
        return "hello from version-3";
    }
}
