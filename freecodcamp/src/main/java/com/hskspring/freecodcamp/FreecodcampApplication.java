package com.hskspring.freecodcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FreecodcampApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(FreecodcampApplication.class, args);
        MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
        System.out.println(myFirstClass.hello());
    }

}
