package com.ghailene.currencyexchangeservice.controller;

import com.ghailene.currencyexchangeservice.CurrencyExchangeServiceApplication;
import com.ghailene.currencyexchangeservice.entity.CurrencyExchange;
import com.ghailene.currencyexchangeservice.repositories.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);



    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retreiveExchangeValue(@PathVariable String from, @PathVariable String to){

        logger.info("retrieve Exchange Value called with {} to {}",from,to);
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from,to);
        if (currencyExchange==null){
            throw new RuntimeException("Unable to find data for " + from + "to "+ to);
        }
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        logger.info("ghailene ben marzouk test when exvhange money");
        return currencyExchange;
    }
}
