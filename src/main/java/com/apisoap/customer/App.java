package com.apisoap.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = {"com.apisoap.customer.*"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
