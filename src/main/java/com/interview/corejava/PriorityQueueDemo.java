package com.interview.corejava;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // Create a PriorityQueue of integers
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // Add elements to the priority queue
        queue.add(1);
        queue.add(5);
        queue.add(20);
        queue.add(15);

        // Print and remove elements from the priority queue
        System.out.println("Priority Queue Elements (in priority order):");
        while (!queue.isEmpty()) {
            // Remove and print the element with the highest priority
            System.out.println(queue.poll());
        }
    }
}
