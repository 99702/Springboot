package com.example.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@Configuration
/*
We can now make inside methods that returns java beans.
*/
@ComponentScan(basePackages = {"mypack"})
public class MyConfig {

//    @Bean // send object to spring container
    @Bean("getStudent")
    @Lazy // adding this only create getStudent not other methods metioned by @Qualifier
    public Student getStudent(){
        System.out.println("getting studying object.");
        return new Student();
    }

    @Bean("createStudent")
    @Lazy
//    @Bean // send object to spring container
    public Student createStudent(){
        System.out.println("creating studying object.");
        return new Student();
    }


    @Bean
    public Date getDate(){
        System.out.println("creating new date");
        return new Date();
    }
}
