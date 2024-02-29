package com.interview.corejava;

class Vehicle {

    void test1() {

        System.out.println("In class Vehicle.");
    }
}

class Car extends Vehicle {

    void test2() {

        System.out.println("In class Car.");
    }
}

public class InheritanceDemo1 {
    public static void main(String[] args) {

        Vehicle v = new Car();
        v.test2();

        Car c = new Vehicle();
        c.test1();
    }
}
