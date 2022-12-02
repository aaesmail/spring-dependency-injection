package com.example.dependencyinjection.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.dependencyinjection.services.ConstructorGreetingService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetterInjectedControllerTest {
    SetterInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new SetterInjectedController();
        controller.setGreetingService(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {
        assertEquals(controller.getGreeting(), "Hello World");
    }
}
