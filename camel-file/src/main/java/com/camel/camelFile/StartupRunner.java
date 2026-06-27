package com.camel.camelFile;

import com.camel.camelFile.Config.CamelConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {
    private final CamelConfig camelConfig;

    public StartupRunner(CamelConfig camelConfig) {
        this.camelConfig = camelConfig;
    }

    @Override
    public void run(String... args) {
        camelConfig.setupRoutes();
        System.out.println("Application started!");

    }
}