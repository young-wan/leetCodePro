package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author wanyang
 * @description 冒泡排序
 * @date 2022/1/19
 */
public class BubbleSort {
    /*
    冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
    走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
    这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。

    算法描述
    1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
    2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
    3. 针对所有的元素重复以上的步骤，除了最后一个；
    4. 重复步骤1~3，直到排序完成。
     */

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(bubbleSort(IntegerUtils.ints)));
        System.out.println(Arrays.toString(bubble2(IntegerUtils.ints)));
    }

    private static int[] bubbleSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.println("=====================");
        int temp;
        for (int i = 0; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                // 1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
                // 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    private static int[] bubble2(int[] arr) {
        /**
         *     1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
         *     2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
         *     3. 针对所有的元素重复以上的步骤，除了最后一个；
         *     4. 重复步骤1~3，直到排序完成。
         */

        int tmp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }


        return arr;
    }
}

