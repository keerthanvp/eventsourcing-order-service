package com.vpk.tutorial.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProductPriceConfig {

    @Bean
    public Map<Integer, Integer> productPrice(){
        Map<Integer,Integer> productPriceMap = new HashMap<>();
        productPriceMap.put(1,100);
        productPriceMap.put(2,250);
        productPriceMap.put(3,550);
        productPriceMap.put(4,150);
        productPriceMap.put(5,800);
        productPriceMap.put(6,450);
        productPriceMap.put(7,300);
        productPriceMap.put(8,200);
        productPriceMap.put(9,950);
        productPriceMap.put(10,50);
        return productPriceMap;
    }
}
