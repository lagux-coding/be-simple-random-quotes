package com.kusl.randomGeneratorBE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RandomQuotesGeneratorBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomQuotesGeneratorBeApplication.class, args);
    }

}
