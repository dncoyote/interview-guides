package com.interview.corejava;

class A extends Thread {
    public void show() {
        for (int i = 0; i < 9; i++)
            System.out.println("hi");
    }
}

class B extends Thread {
    public void show() {
        for (int i = 0; i < 9; i++)
            System.out.println("hello");
    }
}

public class ThreadsDemo {
    public static void main(String[] args) {

        A obj1 = new A();
        B obj2 = new B();

        obj1.show();
        obj2.show();

    }

}
