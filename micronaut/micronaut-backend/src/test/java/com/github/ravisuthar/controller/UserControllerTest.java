package com.github.ravisuthar.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MicronautTest
public class UserControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);
	
	@Inject
    private EmbeddedServer server; 

    @Inject
    @Client("/user")
    private RxHttpClient client; 

    /*@Inject
    private UserControllerClient userControllerClient;*/

    @Test
    void getAll_test() {
        String response = client.toBlocking() 
                .retrieve(HttpRequest.GET("/users"));
        LOGGER.info(response);
        Assertions.assertNotNull(response);
        Assertions.assertEquals("[{\"id\":\"1\",\"name\":\"ABC\",\"email\":\"abc@abc.abc\"},{\"id\":\"2\",\"name\":\"xyz\",\"email\":\"xyz@xyz.xyz\"}]", response); //) 
    }
    
    /*@Test
    public void testHelloWorldResponse() {
        Assertions.assertEquals("", userControllerClient.getAll().blockingGet());
    }
    */
}
