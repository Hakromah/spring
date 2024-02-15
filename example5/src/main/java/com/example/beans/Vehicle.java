package com.example.beans;

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

    public void printHello() {
        System.out.println("Printing Hello from Component Vehicle Beans");
    }
}
