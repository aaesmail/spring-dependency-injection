package com.example.dependencyinjection.services;

public class PrimaryGreetingService implements GreetingService {
    private int count = 0;

    @Override
    public String sayGreeting() {
        return "Hello World - Primary Bean " + ++count;
    }
}
