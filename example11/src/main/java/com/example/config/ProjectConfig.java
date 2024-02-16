package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.example.beans")
public class ProjectConfig {
//    @Bean
//    public Vehicle vehicle() {
//        Vehicle vehicle = new Vehicle();
//        vehicle.setName("Toyota");
//        return vehicle;
//    }
//
//    // method parameter approach
//    @Bean
//    public Person person() {
//        Person person = new Person();
//        person.setName("Lucy");
//        return person;
//    }
}
