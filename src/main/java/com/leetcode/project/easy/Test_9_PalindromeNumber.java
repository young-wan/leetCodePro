package com.leetcode.project.easy;

/**
 * @author Young
 * @create 2019-11-19 21:50
 * @desc leetcode
 * {@link} https://leetcode.com/problems/palindrome-number/
 **/
public class Test_9_PalindromeNumber {
   /*
    Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
    Example 1:
    Input: 121
    Output: true

    Example 2:
    Input: -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

    Example 3:
    Input: 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
    Follow up:
    Coud you solve it without converting the integer to a string?
    */

    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        long res = 0;
        int temp = x;
        while (0 != temp) {
            res = res * 10 + temp % 10;
            temp /= 10;
        }
        return res == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
}
