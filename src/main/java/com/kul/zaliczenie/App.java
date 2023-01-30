package com.kul.zaliczenie;

import com.kul.zaliczenie.printer.MainPrinter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EntityScan(basePackages = {"com.kul.zaliczenie.entity"})
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        MainPrinter bean = run.getBean(MainPrinter.class);
        bean.process();

    }
}
