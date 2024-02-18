package com.interview.corejava;

@FunctionalInterface
interface HelloWorld {
    void sayHello();
}

public class HelloWorldLambda {
    public static void main(String[] args) {
        // Lambda expression as implementation of the sayHello method
        HelloWorld helloWorld = () -> {
            System.out.println("Hello, World!");
        };

        // Invoking the sayHello method using the lambda expression
        helloWorld.sayHello(); // Output: Hello, World!
    }
}
