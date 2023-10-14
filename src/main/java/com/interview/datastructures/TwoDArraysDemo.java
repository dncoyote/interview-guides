package com.interview.datastructures;

import java.util.Arrays;

public class TwoDArraysDemo {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        board[0][0] = '0';
        System.out.println(Arrays.deepToString(board));

        char[][] boardTwo = new char[][] {
                new char[] { '0', '-', '-' },
                new char[] { '-', '-', '-' },
                new char[] { '-', '-', '-' }
        };
        System.out.println(Arrays.deepToString(boardTwo));
    }
}
