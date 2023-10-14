package com.interview.corejava;

abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    // Abstract method
    abstract void makeSound();

    // Concrete method
    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    // Implementation of the abstract method
    void makeSound() {
        System.out.println(name + " barks");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    // Implementation of the abstract method
    void makeSound() {
        System.out.println(name + " meows");
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        Animal animal1 = new Dog("Buddy");
        Animal animal2 = new Cat("Whiskers");

        animal1.makeSound(); // Output: Dog barks
        animal2.makeSound(); // Output: Cat meows

        animal1.sleep(); // Output: Animal is sleeping
        animal2.sleep(); // Output: Animal is sleeping
    }
}
