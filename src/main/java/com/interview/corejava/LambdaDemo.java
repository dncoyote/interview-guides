package com.interview.corejava;

@FunctionalInterface
interface Greeting {
    void greet(String name);
}

public class LambdaDemo {
    public static void main(String[] args) {
        // Lambda expression as implementation of the greet method
        Greeting greeting = (name) -> {
            System.out.println("Hello, " + name + "!");
        };

        // Invoking the greet method using the lambda expression
        greeting.greet("John"); // Output: Hello, John!
    }
}