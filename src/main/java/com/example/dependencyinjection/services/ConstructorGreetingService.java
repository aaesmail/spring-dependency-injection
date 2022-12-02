package com.example.dependencyinjection.services;

public class ConstructorGreetingService implements GreetingService {
    private int count = 0;

    @Override
    public String sayGreeting() {
        return "Hello World - Constructor Injected " + ++count;
    }
}
