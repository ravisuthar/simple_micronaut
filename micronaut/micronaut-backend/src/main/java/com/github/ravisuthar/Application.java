package com.github.ravisuthar;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Hello World",
                version = "0.0",
                description = "My API",
                license = @License(name = "Apache 2.0", url = "https://github.com/ravisuthar"),
                contact = @Contact(url = "https://github.com/ravisuthar", 
                				  name = "Ravi Suthar", 
                				  email = "ravisut1@gmail.com")
        )
)
public class Application {
	public static void main(String[] args) {
		Micronaut.run(Application.class);
	}
}
