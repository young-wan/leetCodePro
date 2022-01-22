package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author wanyang
 * @description 插入排序
 * @date 2022/1/19
 */
public class InsertionSort {
    /*
    插入排序（Insertion-Sort）是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

    算法步骤：
    1. 从第一个元素开始，该元素可以认为已经被排序；
    2. 取出下一个元素，在已经排序的元素序列中从后向前扫描；
    3. 如果该元素（已排序）大于新元素，将该元素移到下一位置；
    4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
    5. 将新元素插入到该位置后；
    6. 重复步骤2~5。

     算法分析
    插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。

     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insert2(IntegerUtils.ints)));

    }

    private static int[] insertionSort(int[] arr) {
        int tmp;
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        //  1. 从第一个元素开始，该元素可以认为已经被排序；
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            // 记录要插入的数据
            // 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描；
            tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            while (j > 0 && tmp < arr[j - 1]) {
                // 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置；
                arr[j] = arr[j - 1];
                // 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
                j--;
            }
            // 存在比其小的数，插入
            // 5. 将新元素插入到该位置后；
            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }

    private static int[] insert2(int[] arr) {

        /*
        1. 从第一个元素开始，该元素可以认为已经被排序；
        2. 取出下一个元素，在已经排序的元素序列中从后向前扫描；
        3. 如果该元素（已排序）大于新元素，将该元素移到下一位置；
        4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
        5. 将新元素插入到该位置后；
        6. 重复步骤2~5。
         */


        int tmp;

        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = tmp;
            }
        }

        return arr;
    }
}
