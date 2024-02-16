package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Hassan";

    @Autowired// THIS IS THE BEST APPROACH OF AUTOWIRING (on the constructor)
    public Person(Vehicle vehicle) {
        System.out.println("Person bean created by Spring");
        this.vehicle = vehicle;
    }

    //@Autowired // this approach you can't make vehicle variable final
    private Vehicle vehicle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Autowired // this approach you can't make vehicle variable final
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
