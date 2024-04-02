package com.interview.corejava;

public class WaitSleepDemo {
    public static void main(String[] args) {
        Object lock = new Object();

        // Thread 1: Uses wait() method
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 is waiting...");
                    lock.wait(); // Releases lock and waits for notification
                    System.out.println("Thread 1 is awake!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Thread 2: Uses sleep() method
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3000); // Sleep for 3 seconds
                synchronized (lock) {
                    System.out.println("Thread 2 is notifying...");
                    lock.notify(); // Notifies waiting thread
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
