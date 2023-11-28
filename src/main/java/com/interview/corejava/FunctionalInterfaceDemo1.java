package com.interview.corejava;

@FunctionalInterface
interface MyFunctionalInterface {
    // Abstract method
    void myMethod();

    // Default method
    default void myDefaultMethod() {
        System.out.println("Default method implementation");
    }

    // Static method
    static void myStaticMethod() {
        System.out.println("Static method implementation");
    }
}

public class FunctionalInterfaceDemo1 {
    public static void main(String[] args) {
        // Lambda expression for the abstract method
        MyFunctionalInterface myFunction = () -> System.out.println("Lambda expression for myMethod");

        // Calling the abstract method using the lambda expression
        myFunction.myMethod();

        // Calling the default method
        myFunction.myDefaultMethod();

        // Calling the static method
        MyFunctionalInterface.myStaticMethod();
    }
}
