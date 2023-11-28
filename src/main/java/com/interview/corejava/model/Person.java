package com.interview.corejava.model;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void printDetails() {
        System.out.println("Person: " + name);
    }
}
