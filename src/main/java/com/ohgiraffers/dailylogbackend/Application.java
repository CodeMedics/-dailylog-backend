package com.ohgiraffers.dailylogbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.context.annotation.PropertySource;

import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
@PropertySource("classpath:application.yml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        String uuid = UUID.randomUUID().toString();
    }

}
