package com.interview.corejava;

class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println("I am an animal.");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public void speak() {
        System.out.println("I am a cat.");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void speak() {
        System.out.println("I am a dog.");
    }
}

public class MainDemo {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Generic Animal");
        Animal cat1 = new Cat("Fluffy");
        Animal dog1 = new Dog("Rover");

        animal1.speak(); // Output: I am an animal.
        cat1.speak(); // Output: I am a cat.
        dog1.speak(); // Output: I am a dog.
    }
}