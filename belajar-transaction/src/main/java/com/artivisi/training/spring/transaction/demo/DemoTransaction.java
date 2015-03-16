package com.artivisi.training.spring.transaction.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoTransaction {
    public static void main(String[] args) {
        System.out.println("Demo Transaction");
        SpringApplication.run(DemoTransaction.class, args);
    }
}
