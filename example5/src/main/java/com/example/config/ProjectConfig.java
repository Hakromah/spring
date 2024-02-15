package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.example.beans")
public class ProjectConfig {

//    @Bean(name = "audiVehicle")
////custom bean naming
//    Vehicle vehicle1() {
//        var veh = new Vehicle();
//        veh.setName("Audi");
//        return veh;
//    }
//
//    //custom bean naming
//    @Bean(value = "hondaVehicle")
//    Vehicle vehicle2() {
//        var veh = new Vehicle();
//        veh.setName("Honda");
//        return veh;
//    }
//
//    @Primary// it will be default bean method
//    @Bean("ferrariVehicle")
//    Vehicle vehicle3() {
//        var veh = new Vehicle();
//        veh.setName("Ferrari");
//        return veh;
//    }
//
//    @Bean
//    String hello() {
//        return "Hello World";
//    }
//
//    @Bean
//    Integer number() {
//        return 21;
//    }

}
