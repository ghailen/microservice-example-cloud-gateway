package com.ghailene.currencyconversionservice.configuration;

import com.ghailene.currencyconversionservice.entities.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// this is the name of the micorservice currency exchange which exist in spring.application.name and the url of the microservice (only the host) as second parameter
//
//@FeignClient(name="currency-exchange",url="localhost:8000")  // by deleting the url , the loadbalancing will work (no specific url for exchange)
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retreiveExchangeValue(@PathVariable String from, @PathVariable String to);
}

