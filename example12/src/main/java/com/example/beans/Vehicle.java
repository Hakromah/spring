package com.example.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String name = "Toyota";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " - " + name;
    }
}
