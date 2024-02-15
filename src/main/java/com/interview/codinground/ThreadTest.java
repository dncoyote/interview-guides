package com.interview.codinground;

public class ThreadTest{

    // @Override
    // public void run() {
    //     System.out.println("Hi");
    // }

    public static void main(String[] args) {
        
        Runnable myRunnable = ()->System.out.println("Hi");

        myRunnable.run();
    }
    
}
