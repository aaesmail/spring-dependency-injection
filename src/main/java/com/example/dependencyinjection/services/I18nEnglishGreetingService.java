package com.example.dependencyinjection.services;

import com.example.dependencyinjection.repositories.EnglishGreetingRepository;

public class I18nEnglishGreetingService implements GreetingService {
    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return this.englishGreetingRepository.getGreeting();
    }
}
