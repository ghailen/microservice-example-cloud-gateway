package com.ghailene.apigatway;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {


    private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // her we are we are logging the path of request
        logger.info("Path fo the request receiver - {}",exchange.getRequest().getPath());

        //here we are letting the chain continue
        return chain.filter(exchange);
    }
}
