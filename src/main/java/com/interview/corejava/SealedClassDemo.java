package com.interview.corejava;


sealed abstract class A permits B, C{
    abstract void display();
}

// Non-sealed class B extending A
non-sealed class B extends A {
    @Override
    void display() {
        System.out.println("Class B");
    }

    void specificMethodB() {
        System.out.println("Specific method of class B");
    }
}

// Final class C extending A
final class C extends A {
    @Override
    void display() {
        System.out.println("Class C");
    }

    void specificMethodC() {
        System.out.println("Specific method of class C");
    }
}

// Class D extending B
class D extends B {
    void specificMethodD() {
        System.out.println("Specific method of class D");
    }
}

public class SealedClassDemo {
    public static void main(String[] args) {
        // Creating instances and demonstrating functionality
        A objB = new B();
        A objC = new C();
        B objD = new D();

        // objB.display(); // Outputs: Class B
        // objC.display(); // Outputs: Class C

        // objB.specificMethodB(); // Compilation error: specificMethodB() not in sealed hierarchy
        // objC.specificMethodC(); // Compilation error: specificMethodC() not in sealed hierarchy

        // ((B) objB).specificMethodB(); // Outputs: Specific method of class B
        // ((D) objD).specificMethodD(); // Outputs: Specific method of class D
    }
}
