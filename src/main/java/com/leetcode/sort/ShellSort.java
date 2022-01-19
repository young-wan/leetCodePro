package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author wanyang
 * @description 希尔排序
 * @date 2022/1/19
 */
public class ShellSort {

    /*
    希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法。
    第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
    基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。

    算法步骤：
    1. 选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
    2. 按增量序列个数 k，对序列进行 k 趟排序；
    3. 每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。


     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shellSort(IntegerUtils.ints)));
    }


    private static int[] shellSort(int[] arr) {
        // 寻找数组分割长度
        int tmp;
        int gap = arr.length, len = arr.length;

        // gap每次增量减半
        while ((gap /= 2) > 0) {
            for (int i = 0; i < gap; i++) {
                //这个循环里其实就是一个插入排序
                // j每次递增一个gap长度
                for (int j = i + gap; j < len; j += gap) {
                    int k = j;
                    while (k - gap >= 0 && arr[k - gap] > arr[k]) {
                        tmp = arr[k];
                        arr[k] = arr[k - gap];
                        arr[k - gap] = tmp;
                        // 往前递减比较
                        k -= gap;
                    }
                }
            }
        }
        return arr;
    }
}
