package com.interview.corejava;

@FunctionalInterface
interface MyInterface {
    // void print();

    void sayHello();
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        // MyInterface obj = new MyInterface() {

        // @Override
        // public void print() {
        // System.out.println("Printing");
        // throw new UnsupportedOperationException("Unimplemented method 'print'");
        // }

        // };
        // obj.print();

        MyInterface obj = () -> {
            System.out.println("Hello, World!");
        };
        obj.sayHello();
    }
}