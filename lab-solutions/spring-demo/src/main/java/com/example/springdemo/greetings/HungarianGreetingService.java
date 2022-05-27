package com.example.springdemo.greetings;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("HU")
@Service
public class HungarianGreetingService implements GreetingService {


    @Override
    public String sayHello() {
        return "Hello Világ!";
    }

}
