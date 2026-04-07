package com.Bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Main class for BankmanagementApp1 Spring Boot application.
 * Modified for WAR deployment on external Tomcat.
 */
@SpringBootApplication
public class Bankmangementapp1Application extends SpringBootServletInitializer {

    /**
     * This method is used by external Tomcat to configure the application.
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Bankmangementapp1Application.class);
    }

    /**
     * Main method to run the Spring Boot application as a standalone JAR if needed.
     */
    public static void main(String[] args) {
        SpringApplication.run(Bankmangementapp1Application.class, args);
    }
}

