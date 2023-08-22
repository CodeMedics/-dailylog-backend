package com.ohgiraffers.dailylogbackend.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@Configuration
@EntityScan(basePackages = "com.ohgiraffers.dailylogbackend")
@EnableJpaRepositories(basePackages = "com.ohgiraffers.dailylogbackend")
public class JPAConfiguration {
}
