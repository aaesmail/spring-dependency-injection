package com.example.dependencyinjection.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.dependencyinjection.services.ConstructorGreetingService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConstructorInjectedControllerTest {
    ConstructorInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new ConstructorInjectedController(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {
        assertEquals(controller.getGreeting(), "Hello World");
    }
}
