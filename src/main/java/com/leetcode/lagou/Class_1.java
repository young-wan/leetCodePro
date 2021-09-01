package com.leetcode.lagou;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author young
 * @Date 2021/6/15 14:30
 * @Desc
 **/
public class Class_1 {
    public static void main(String[] args) {
        String testStr = "{}{{}}{{}}";
//        System.out.println(isValidByStack(testStr));
//        System.out.println(isValidByNum(testStr));
//        String multiStr = "(){()[]}[]{}";
//        System.out.println(isValidByMulti(multiStr));
        int[] ints = new int[]{1, 2, 4, 9, 4, 0, 5};
        System.out.println(Arrays.toString(findRightSmall(ints)));
        System.out.println(Arrays.toString(findRightBigger(ints)));
        System.out.println(Arrays.toString(findLeftSmall(ints)));
        System.out.println(Arrays.toString(findLeftBigger(ints)));
//        int[] ints2 = new int[]{3, 5, 2, 6};
//        System.out.println(Arrays.toString(findSmallSeq(ints2, 3)));
    }


    static boolean isValidByStack(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '{') {
                stack.push(c);
            } else if (!stack.empty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    static boolean isValidByNum(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        int number = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '{') {
                number++;
            } else if (number > 0) {
                number--;
            } else {
                return false;
            }
        }
        return number == 0;
    }

    static boolean isValidByMulti(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        char c;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (!stack.empty()) {
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                }
            } else {
                return false;
            }
        }
        return stack.empty();
    }


    /**
     * 【题目】在水中有许多鱼，可以认为这些鱼停放在 x 轴上。再给定两个数组 Size，Dir，Size[i] 表示第 i 条鱼的大小，
     * Dir[i] 表示鱼的方向 （0 表示向左游，1 表示向右游）。这两个数组分别表示鱼的大小和游动的方向，并且两个数组的长度相等。
     * 鱼的行为符合以下几个条件:
     * 所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离；
     * 当方向相对时，大鱼会吃掉小鱼；
     * 鱼的大小都不一样。
     * 输入：Size = [4, 2, 5, 3, 1], Dir = [1, 1, 0, 0, 0]
     * 输出：3
     * 请完成以下接口来计算还剩下几条鱼？
     *
     * @param Size
     * @param Dir
     * @return
     */
    static int solution(int[] Size, int[] Dir) {
        final int fishTotal = Size.length;
        final int left = 0;
        final int right = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < fishTotal; i++) {
            final int curDir = Dir[i];
            final int curSize = Size[i];
            boolean hasEat = false;
            while (!stack.empty() && curDir == left && Dir[stack.peek()] == right) {
                if (curSize > Size[stack.peek()]) {
                    stack.pop();
                } else {
                    hasEat = true;
                    break;
                }
            }
            if (!hasEat) {
                stack.push(i);
            }
        }
        return stack.size();
    }

    /**
     * 一个整数数组 A，找到每个元素：右边第一个比我小的下标位置，没有则用 -1 表示。
     *
     * @param ints
     * @return
     */
    static int[] findRightSmall(int[] ints) {
        Stack<Integer> stack = new Stack<>();
        int cur;
        int[] ans = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            cur = ints[i];
            while (!stack.empty() && cur < ints[stack.peek()]) {
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }

    /**
     * 数组中右边第一个比我大的元素的位置
     */
    static int[] findRightBigger(int[] ints) {
        Stack<Integer> stack = new Stack<>();
        int cur;
        int[] ans = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            cur = ints[i];
            while (!stack.empty() && cur > ints[stack.peek()]) {
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }


    /**
     * 数组中元素左边离我最近且比我小的元素的位置
     */
    static int[] findLeftSmall(int[] ints) {
        Stack<Integer> stack = new Stack<>();
        int cur;
        int[] ans = new int[ints.length];
        for (int i = ints.length - 1; i >= 0; i--) {
            cur = ints[i];
            while (!stack.empty() && cur < ints[stack.peek()]) {
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }


    /**
     * 数组中元素左边离我最近且比我大的元素的位置
     */
    static int[] findLeftBigger(int[] ints) {
        Stack<Integer> stack = new Stack<>();
        int cur;
        int[] ans = new int[ints.length];
        for (int i = ints.length - 1; i >= 0; i--) {
            cur = ints[i];
            while (!stack.empty() && cur > ints[stack.peek()]) {
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }

    /**
     * 【题目】给定一个正整数数组和 k，要求依次取出 k 个数，输出其中数组的一个子序列，需要满足：1. 长度为 k；2.字典序最小。
     * 输入：nums = [3,5,2,6], k = 2
     * 输出：[2,6]
     *
     * @param nums
     * @param k
     * @return
     */
    static int[] findSmallSeq(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int cur;
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i];
            int left = nums.length - i;
            while (!stack.empty() && cur < nums[stack.peek()] && (left + stack.size()) > k) {
                stack.pop();
            }
            stack.push(i);
        }
        int[] ans = new int[stack.size()];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = nums[stack.pop()];
        }
        return ans;
    }

    /**
     * 给定一个数组，数组中的元素代表木板的高度。请你求出相邻木板能剪出的最大矩形面积。
     *
     * @param ints
     */
    static int biggestArea(int[] ints) {

        return 0;
    }
}
