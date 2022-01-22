package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author wanyang
 * @description 选择排序
 * @date 2022/1/19
 */
public class SelectionSort {

    /*
    选择排序(Selection-sort)是一种简单直观的排序算法。

    算法步骤
    1. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
    2. 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
    3. 重复第二步，直到所有元素均排序完毕。

    复杂度：
    O(n²)

    算法分析：
    表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(select2(IntegerUtils.ints)));
    }

    private static int[] selectionSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length; i++) {
            // 1. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
            min = i;
            // 2. 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (min != i) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }


    private static int[] select2(int[] arr) {
        /*
        1. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
        2. 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
        3. 重复第二步，直到所有元素均排序完毕。
         */

        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                IntegerUtils.swap(arr, minIndex, i);
            }
        }

        return arr;
    }
}
