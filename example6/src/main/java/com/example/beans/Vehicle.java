package com.example.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component// it will convert this pojo class to Spring Bean
public class Vehicle {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @PostConstruct // from Java Enterprise Edition JavaEE.
    public void initialize() {
        this.name = "Honda";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Vehicle Bean");
    }

    public void printHello() {
        System.out.println("Printing Hello from Component Vehicle Beans");
    }
}
