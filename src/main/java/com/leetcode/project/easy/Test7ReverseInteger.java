package com.leetcode.project.easy;

import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

/**
 * @title: leetCode
 * @author: Young
 * @desc: leetcode
 * @date: Created at 2019/11/19 2019 14:07
 * {@link} https://leetcode.com/problems/reverse-integer/
 */
public class Test7ReverseInteger {
    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     * Example 1:
     * Input: 123
     * Output: 321
     * <p>
     * Example 2:
     * Input: -123
     * Output: -321
     * <p>
     * Example 3:
     * Input: 120
     * Output: 21
     * <p>
     * Note:
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed
     * integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function
     * returns 0 when the reversed integer overflows.
     */
    public int reverse1(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        return Integer.valueOf(String.valueOf(sb.reverse()));
    }

    public int reverse2(int x) {
        //  环境只能存下32位,不可用long
        long res = 0;
        for (; x != 0; x /= 10) {
            res = res * 10 + x % 10;
        }
        if (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE) {
            return (int) res;
        }
        return 0;
    }

    public int reverse3(int x) {
        int res = 0;
        while (0 != x) {
            int pop = x % 10;
            x /= 10;
            /**
             * 令temp = res * 10 + pop; (假设res为正数)
             * 如果发生溢出,则必定有 temp > INT_MAX --> res >= (INT_MAX - pop) / 10 --> res >= INT_MAX / 10
             * 1.若res > INT_MAX / 10, 则temp必定溢出
             * 2.若res = INT_MAX / 10, 当pop > (INT_MAX % 10) 时,会溢出
             */
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                //  上一次的res大于最大值/10,则必定溢出;若res等于最大值/10,且pop大于最大值尾数,也会溢出
                return 0;
            } else if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE / 10)) {
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }
}
