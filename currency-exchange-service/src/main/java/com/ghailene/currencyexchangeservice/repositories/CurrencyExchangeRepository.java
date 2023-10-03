package com.ghailene.currencyexchangeservice.repositories;

import com.ghailene.currencyexchangeservice.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {

CurrencyExchange findByFromAndTo(String from,String to);



}
