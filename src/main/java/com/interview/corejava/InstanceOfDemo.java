package com.interview.corejava;

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Dog barks");
    }
}

public class InstanceOfDemo {
    public static void main(String[] args) {
        Animal animal = new Dog();

        if (animal instanceof Dog dog) {
            dog.bark(); // No explicit casting needed
        } else {
            animal.makeSound();
        }
    }
}
