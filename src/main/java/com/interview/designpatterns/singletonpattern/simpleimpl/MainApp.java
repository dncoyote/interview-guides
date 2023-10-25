package com.interview.designpatterns.singletonpattern.simpleimpl;

public class MainApp {

    public static void main(String[] args) {

        System.out.println(Singleton.getInstance("Geekific"));
        Singleton singleton = Singleton.getInstance("Singleton");
        System.out.println(singleton);
        System.out.println(singleton.getData());

    }

}