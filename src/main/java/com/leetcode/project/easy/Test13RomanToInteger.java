package com.leetcode.project.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Young
 * @create 2019-11-19 22:47
 * @desc leetcode
 * {@link} https://leetcode.com/problems/roman-to-integer/
 **/
public class Test13RomanToInteger {
    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

     Symbol       Value
     I             1
     V             5
     X             10
     L             50
     C             100
     D             500
     M             1000
     For example, two is written as II in Roman numeral, just two one's added together.
     Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

     Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
     Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
     The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

     I can be placed before V (5) and X (10) to make 4 and 9.
     X can be placed before L (50) and C (100) to make 40 and 90.
     C can be placed before D (500) and M (1000) to make 400 and 900.
     Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

     Example 1:
     Input: "III"
     Output: 3

     Example 2:
     Input: "IV"
     Output: 4

     Example 3:
     Input: "IX"
     Output: 9

     Example 4:
     Input: "LVIII"
     Output: 58
     Explanation: L = 50, V= 5, III = 3.

     Example 5:
     Input: "MCMXCIV"
     Output: 1994
     Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int res = 0;
        String[] strings = s.split("");
        for (int i = 0; i < strings.length; i++) {
            if ((i + 1) < strings.length && (map.get(strings[i]) < map.get(strings[i + 1]))) {
                res -= map.get(strings[i]);
            } else {
                res += map.get(strings[i]);
            }
        }
        return res;
    }

    public int romanToInt2(String s) {
        int res = 0;
        int prev = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            cur = digit(s.charAt(i));
            if (prev < cur) {
                res -= prev;
                res += cur - prev;
            } else {
                res += cur;
            }
            prev = cur;
        }
        return res;
    }

    private int digit(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
