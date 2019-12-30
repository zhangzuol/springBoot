package com.example.springBoot.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order
public class Runner implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("The Runner start to initialize ...=====================");
    }
}
