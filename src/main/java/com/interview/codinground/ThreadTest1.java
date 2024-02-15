package com.interview.codinground;

public class ThreadTest1 {

    public static void main(String[] args) {
        // Define a Runnable task
        Runnable myRunnable = () -> {
            try {
                // Simulate some work by sleeping for 1 second
                Thread.sleep(1000);
                // Print a message after the sleep
                System.out.println("Thread 1: Hello");
                // Wait for another thread to notify
                synchronized (ThreadTest.class) {
                    ThreadTest.class.wait();
                }
                // After being notified, print a message
                System.out.println("Thread 1: After waiting");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Create and start the first thread
        Thread thread1 = new Thread(myRunnable);
        thread1.start();

        // Create and start the second thread
        Thread thread2 = new Thread(() -> {
            try {
                // Simulate some work by sleeping for 2 seconds
                Thread.sleep(2000);
                // Print a message after the sleep
                System.out.println("Thread 2: Hi");
                // Notify the waiting thread to resume
                synchronized (ThreadTest.class) {
                    ThreadTest.class.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
    }
}
