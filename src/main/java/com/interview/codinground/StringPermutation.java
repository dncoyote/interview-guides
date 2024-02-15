package com.interview.codinground;

public class StringPermutation {

    // Function call
    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();
        StringPermutation permutation = new StringPermutation();
        permutation.permute(str, 0, n - 1);
    }

    /**
     * permutation function
     * 
     * @param str string to calculate permutation for
     * @param l   starting index
     * @param r   end index
     */
    private void permute(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    /**
     * Swap Characters at position
     * 
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
/**
 * In the main method, a string "ABC" is initialized, and the permute method is
 * called with the string, starting index 0, and ending index n - 1, where n is
 * the length of the string.
 * 
 * The permute method recursively generates all permutations of the string. It
 * takes three arguments: the string str, the starting index l, and the ending
 * index r.
 * 
 * If the starting index l is equal to the ending index r, it means that the
 * entire string has been processed, and the current permutation is printed.
 * 
 * Otherwise, it iterates over each character in the string from index l to
 * index r, swapping the characters at positions l and i, recursively calling
 * permute for the next index, and then swapping back the characters to maintain
 * the original order.
 * 
 * The swap method is a utility method that swaps the characters at positions i
 * and j in the string a.
 */