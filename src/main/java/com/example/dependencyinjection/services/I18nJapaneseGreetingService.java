package com.example.dependencyinjection.services;

public class I18nJapaneseGreetingService implements GreetingService {
    private int count = 0;

    @Override
    public String sayGreeting() {
        return "こんにちは、世界 - JP " + ++count;
    }
}
