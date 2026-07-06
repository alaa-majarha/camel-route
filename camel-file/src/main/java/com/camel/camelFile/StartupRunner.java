package com.camel.camelFile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {


    public StartupRunner() {

    }

    @Override
    public void run(String... args) {

        System.out.println("Application started!");

    }
}