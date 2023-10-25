package com.interview.designpatterns.singletonpattern.simpleimpl;

public class Singleton {
    private String data;
    private static Singleton instance;

    public Singleton(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public static Singleton getInstance(String data) {
        if (instance == null) {
            instance = new Singleton(data);
        }
        return instance;
    }
}
