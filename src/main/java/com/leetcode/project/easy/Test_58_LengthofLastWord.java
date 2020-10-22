package com.leetcode.project.easy;

/**
 * @title: leetCode
 * @author: Young
 * @desc: leetcode
 * @date: Created at 2019/11/21 2019 16:00
 * {@link} https://leetcode.com/problems/length-of-last-word/
 */
public class Test_58_LengthofLastWord {
    /*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
    return the length of last word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

    Example:
    Input: "Hello World"
    Output: 5 "b   a    "
    */

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello Wor"));
    }
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //  当前最大数
        int max = 0;
        //  前一个最大数
        int lastLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                //  当前char不为空,max++,lastLen=max
                lastLen = ++max;
            } else {
                //  当前char为空
                if (max != 0) {
                    //  若当前max不为空,则赋值给lastLen
                    lastLen = max;
                }
                //  max置为0
                max = 0;
            }
        }
        return lastLen;
    }

    public int lengthOfLastWord2(String s) {
        int len = 0;
        //  只关注最后的word,从后往前遍历
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                //  当找到空值且len不为0时,返回
                if (len != 0) {
                    return len;
                }
            } else {
                len++;
            }
        }
        return len;
    }
}
