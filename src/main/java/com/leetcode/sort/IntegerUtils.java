package com.leetcode.sort;

/**
 * @author wanyang
 * @description
 * @date 2022/1/19
 */
public class IntegerUtils {
    public static final int[] ints = new int[]{69, 93, 29, 3, 6, 72, 99, 10, 22, 15, 41, 37, 12, 12, 5, 61};
    public static final int[] ints2 = new int[]{69, 93, 29, 3, 6, 72,};


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
