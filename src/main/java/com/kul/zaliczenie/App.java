package com.kul.zaliczenie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EntityScan(basePackages = {"com.kul.zaliczenie.entity"})
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
    }
}
