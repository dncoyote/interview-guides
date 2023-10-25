package com.interview.designpatterns.singletonpattern.threadsafeimpl;

public class Singleton {
    private String data;
    private static volatile Singleton instance;

    public Singleton(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public static Singleton getInstance(String data) {
        Singleton result = instance;
        if (result == null) {
            // only one thread at a time can enter this critical section
            synchronized (Singleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Singleton(data);
                }
            }
        }
        return result;
    }
}