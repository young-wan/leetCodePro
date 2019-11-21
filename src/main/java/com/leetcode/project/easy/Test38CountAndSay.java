package com.leetcode.project.easy;

/**
 * @title: leetCode
 * @author: Young
 * @desc: leetcode
 * @date: Created at 2019/11/21 2019 10:30
 * {@link} https://leetcode.com/problems/count-and-say/
 */
public class Test38CountAndSay {
   /*
   The count-and-say sequence is the sequence of integers with the first five terms as following:

    1.     1
    2.     11
    3.     21
    4.     1211
    5.     111221
    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.

    Given an integer n where 1 ≤ n ≤ 30, generate the n^th term of the count-and-say sequence.

    Note: Each term of the sequence of integers will be represented as a string.
    */

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        //  找到n-1的结果
        String prev = countAndSay(n - 1);

        //  数字重复次数
        int count;
        //  当前char
        char c;
        for (int i = 0; i < prev.length(); i++) {
            // 初始化count和c
            count = 1;
            c = prev.charAt(i);
            while ((i + 1) < prev.length() && prev.charAt(i + 1) == c) {
                //  若后一个的值和c相等,叠加++后继续while循环
                count++;
                i++;
            }
            sb.append(count + "" + c);
        }
        return sb.toString();
    }
}
