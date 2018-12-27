package com.humor.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ActivitiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiesApplication.class, args);
    }

}

