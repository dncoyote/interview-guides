package com.interview.codinground.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class VisibleTowers {
    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(3);
        heights.add(7);
        heights.add(2);
        heights.add(5);
        heights.add(6);
        heights.add(4);

        List<Integer> visibleTowers = findVisibleTowers(heights);
        System.out.println("Visible towers: " + visibleTowers);
    }

    public static List<Integer> findVisibleTowers(ArrayList<Integer> heights) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> visibleTowers = new ArrayList<>();

        for (int i = 0; i < heights.size(); i++) {
            while (!stack.isEmpty() && heights.get(i) > heights.get(stack.peek())) {
                stack.pop();
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            visibleTowers.add(heights.get(stack.pop()));
        }

        return visibleTowers;
    }
}
