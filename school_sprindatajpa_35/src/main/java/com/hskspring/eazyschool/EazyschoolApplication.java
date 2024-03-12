package com.hskspring.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com.hskspring.eazyschool.config")
@EnableJpaRepositories("com.hskspring.eazyschool.repository")
@ComponentScan("com.hskspring.eazyschool.model")
public class EazyschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(EazyschoolApplication.class, args);
    }
}
