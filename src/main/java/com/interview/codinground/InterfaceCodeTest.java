package com.interview.codinground;

class Animal {
    public void speak() {
        System.out.println("I am an animal.");
    }
}

class Cat extends Animal {

    public void speak() {
        System.out.println("I am a cat.");
    }
}

public class InterfaceCodeTest {
    private int catId;
    private final String catName;
    private String catBreed;

    public static void main(String[] args) {
        Animal a = new Animal();
        System.out.println("starting..");
        a.speak();
        System.out.println(catId + "" + catName + "" + catBreed);
    }
}
