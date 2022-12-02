package com.example.dependencyinjection.services;

public class SetterInjectedGreetingService implements GreetingService {
    private int count = 0;

    @Override
    public String sayGreeting() {
        return "Hello World - Setter Injected " + ++count;
    }
}
