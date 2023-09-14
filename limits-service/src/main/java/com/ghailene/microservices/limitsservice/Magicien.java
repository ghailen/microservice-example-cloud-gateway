package com.ghailene.microservices.limitsservice;

import java.util.function.BinaryOperator;

public class Magicien {

    public void magic(BinaryOperator<Long> lambda){
        lambda.apply(3L,7L);
    }

}
