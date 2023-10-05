package com.example.CarStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.CarStore")
public class CarStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarStoreApplication.class, args);
    }

}