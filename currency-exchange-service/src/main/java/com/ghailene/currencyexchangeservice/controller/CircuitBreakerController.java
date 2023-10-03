package com.ghailene.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);


    @GetMapping("/sample-api")
    //@Retry(name="sample-api",fallbackMethod = "hardcodedResponse")
    //@CircuitBreaker(name="default",fallbackMethod = "hardcodedResponse")
    //@RateLimiter(name="default")
    //it will allow for example for 10 secondes only 1000 calls to the sample api
    //for this example 2 requests per 10 seconds
    @Bulkhead(name="sample-api")
    //allow only maximum of 100 concurrent calls
    public String sampleApi(){
      //  logger.info("Sample Api call received ");
     // let s create a failure , this an example which will fail
       // ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",String.class);

       // return forEntity.getBody();
        return "sample-api";
    }

    public String hardcodedResponse(Exception ex){
        return "fallback-response";
    }

}
