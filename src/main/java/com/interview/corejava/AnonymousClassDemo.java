package com.interview.corejava;

interface MyNewInterface {
    void doSomething();
}

public class AnonymousClassDemo {
    public static void main(String[] args) {
        // Creating an anonymous class that implements MyInterface
        MyNewInterface myObj = new MyNewInterface() {
            @Override
            public void doSomething() {
                System.out.println("Anonymous class implementing doSomething()");
            }
        };

        // Invoking the method of the anonymous class
        myObj.doSomething();
    }
}