package com.consumingrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.consumingrestapi.proxy")
public class ConsumingrestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumingrestapiApplication.class, args);
    }

}
