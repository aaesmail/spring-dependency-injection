package com.example.dependencyinjection.services;

public class PropertyInjectedGreetingService implements GreetingService {
    private int count = 0;

    @Override
    public String sayGreeting() {
        return "Hello World - Property Injected " + ++count;
    }
}
