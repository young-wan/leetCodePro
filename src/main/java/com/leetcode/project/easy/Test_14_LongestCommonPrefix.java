package com.leetcode.project.easy;

/**
 * @author Young
 * @create 2019-11-19 23:20
 * @desc leetcode
 * {@link} https://leetcode.com/problems/longest-common-prefix/
 **/
public class Test_14_LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(test(new String[]{"flower","flow","flight"}));
    }
    /*
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".

    Example 1:
    Input: ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.

    Note:
    All given inputs are in lowercase letters a-z.
    */

    public static String test(String[] strs) {
        if (null == strs || strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        int n = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            n = n > strs[i].length() ? strs[i].length() : n;
            for (int j = 0; j < n; j++) {
                if (strs[i].charAt(j) != strs[0].charAt(j)) {
                    n = j;
                    break;
                }
            }
        }
        return strs[0].substring(0, n);
    }

    public String longestCommonPrefix(String[] strs) {
        //  判空直接返回
        if(strs == null || strs.length == 0){
            return "";
        }
        int n = strs[0].length();
        if (n == 0){
            return "";
        }
        for (int i = 1; i < strs.length; i++) {
            //  取最小长度
            n = Math.min(n, strs[i].length());
            for (int j = 0; j < n; j++) {
                if (strs[i].charAt(j) != strs[0].charAt(j)) {
                    n = j;
                    break;
                }
            }
        }
        return strs[0].substring(0, n);
    }
}
