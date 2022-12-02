package com.example.dependencyinjection.services;

import org.springframework.stereotype.Component;

@Component
public class SingeltonBean {

    public SingeltonBean() {
        System.out.println("Creating a Singelton Bean!!!");
    }

    public String getMyScope() {
        return "I'm a Singelton";
    }
}
