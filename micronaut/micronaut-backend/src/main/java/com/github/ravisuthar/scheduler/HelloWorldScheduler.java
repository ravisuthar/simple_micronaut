package com.github.ravisuthar.scheduler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Requires(property="${scheduler.enabled}",value="true")
@Singleton 
public class HelloWorldScheduler {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldScheduler.class); 

    //@Scheduled(fixedDelay = "10s") 
    void executeEveryTen() {
        LOG.info("Simple Job every 10 seconds :{}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
    }

    //@Scheduled(fixedDelay = "45s", initialDelay = "5s") 
    void executeEveryFourtyFive() {
        LOG.info("Simple Job every 45 seconds :{}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
    }
    

    @Scheduled(cron = "${scheduler.cron}") 
    void execute() {
    	LOG.info("ravi.suthar@micronaut.example", "Test Message"); 
    }
}