package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author wanyang
 * @description 快排
 * @date 2022/1/20
 */
public class QuickSort {
    /*
    快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
    通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。

    算法步骤：
    1. 从数列中挑出一个元素，称为 “基准”（pivot）;
    2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
    3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；


     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(IntegerUtils.ints, 0, IntegerUtils.ints.length - 1)));

        System.out.println("--------------------");

//        quickSort(IntegerUtils.ints, 0, IntegerUtils.ints.length - 1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        /*
        1. 从数列中挑出一个元素，称为 “基准”（pivot）;
        2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
        3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
         */

        // 1. 从数列中挑出一个元素，称为 “基准”（pivot）;
        // 注意：此时，可以理解为当前下表位的数据已经被取出来了，当前位是空的了，即挖坑填入
        int pivot = arr[left];
        int i = left, j = right;

        // 2. 重新排序数列
        while (i < j) {
            // 所有元素比基准值大的摆在基准的后面
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            // 右边找到的比基准值小的数，放入i处,i++
            if (i < j) {
                arr[i++] = arr[j];
            }

            // 所有元素比基准值小的摆放在基准前面
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            // 将左边比基准值大的放入j处, j--
            if (i < j) {
                arr[j--] = arr[i];
            }
        }

        // 退出循环后，说明i == j，将基准值放入i/j位
        arr[i] = pivot;

        // 3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
        if (i - 1 > left) {
            arr = quickSort(arr, left, i - 1);
        }
        if (j + 1 < right) {
            arr = quickSort(arr, j + 1, right);
        }


        return arr;
    }

    public static void quickSort(Integer arr[], int min, int max) {
        int l = min;
        int h = max;
        int point = arr[min];

        //  l和h未碰面,继续递归
        while (l < h) {
            //  先从右边往前查询
            while (l < h && arr[h] >= point) {
                //  point右边的数都比point大时,往前查询
                h--;
            }
            if (l < h) {
                //  当找到比point小的数时,将该数填入l处;
                arr[l] = arr[h];
                l++;
            }
            //  从左边开始往后查询
            while (l < h && arr[l] <= point) {
                //  point左边的数都比point小时,往后查询
                l++;
            }
            if (l < h) {
                //  当找到比point大的数时,将该数填入h处;
                arr[h] = arr[l];
                h--;
            }
        }
        //  当l和h碰面,说明已经按point的值划分了左右两个小,大的数组;
        //  当前l/h下标即为point
        arr[l] = point;
        //  若还可以继续分解,则递归
        if (l - 1 > min) {
            //  当前的l下标还不是第一位,则递归左边数据
            quickSort(arr, min, l - 1);
        }
        if (h + 1 < max) {
            //  当前的h下标还不是最后一位,则递归右边数据
            quickSort(arr, h + 1, max);
        }
        for (Integer integer : arr) {
            System.out.print(integer + ",");
        }
        System.out.println("--------------------------\n");
    }

}
