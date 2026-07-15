package com.example.mockito;

public class Greeter {

    private final GreetingService greetingService;

    public Greeter(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String greetUser(String name) {
        return greetingService.greet(name);
    }
}
