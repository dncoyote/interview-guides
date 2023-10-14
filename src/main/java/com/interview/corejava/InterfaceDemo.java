package com.interview.corejava;

interface MyInterface {
    // Declare abstract methods
    void method1();
}

public class InterfaceDemo implements MyInterface {

    @Override
    public void method1() {
        System.out.println("hi123");
    }

    public static void main(String[] args) {
        // Creating an object of the HelloWorld class
        InterfaceDemo helloWorld = new InterfaceDemo();

        // Calling the greet() method on the object, which is implementing the Greeting
        // interface
        helloWorld.method1();
    }
}
