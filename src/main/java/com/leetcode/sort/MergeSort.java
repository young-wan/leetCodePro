package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author wanyang
 * @description 归并排序
 * @date 2022/1/19
 */
public class MergeSort {

    /*
    归并排序是建立在归并操作上的一种有效的排序算法。
    该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
    将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
    若将两个有序表合并成一个有序表，称为2-路归并。

    算法步骤：
    1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
    2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
    3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
    4. 重复步骤 3 直到某一指针达到序列尾；
    5. 将另一序列剩下的所有元素直接复制到合并序列尾。

    时间复杂度：
    O(nlogn）

    算法分析：
    归并排序是一种稳定的排序方法。和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(nlogn）的时间复杂度。
    代价是需要额外的内存空间。
     */


    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge2(IntegerUtils.ints, 0, IntegerUtils.ints.length - 1)));

    }


    private static int[] mergeSort(int[] arr, int low, int high) {
        System.out.println("low : " + low + "  high: " + high);
        if (low >= high) {
            return new int[]{arr[low]};
        }

        // 此种写法有可能会导致溢出
//        int mid = (low + high) / 2;

        int mid = low + (high - low) / 2;
        // 左序数组
        int[] leftArr = mergeSort(arr, low, mid);
        // 右序数组
        int[] rightArr = mergeSort(arr, mid + 1, high);
        // 新有序数组  1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
        int[] results = new int[leftArr.length + rightArr.length];

        // 2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
        int i = 0, j = 0, k = 0;
        while (leftArr.length > i && rightArr.length > j) {
            // 3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
            results[k++] = (leftArr[i] < rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }

        //  5. 将另一序列剩下的所有元素直接复制到合并序列尾。
        while (leftArr.length > i) {
            results[k++] = leftArr[i++];
        }
        //  5. 将另一序列剩下的所有元素直接复制到合并序列尾。
        while (rightArr.length > j) {
            results[k++] = rightArr[j++];
        }

        return results;

    }

    private static int[] merge2(int[] arr, int low, int high) {
        /**
         *  1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
         *     2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
         *     3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
         *     4. 重复步骤 3 直到某一指针达到序列尾；
         *     5. 将另一序列剩下的所有元素直接复制到合并序列尾。
         */

        if (low >= high) {
            return new int[]{arr[low]};
        }

        int mid = low + (high - low) / 2;

        int[] leftArr = merge2(arr, low, mid);
        int[] rightArr = merge2(arr, mid + 1, high);

        int[] results = new int[leftArr.length + rightArr.length];

        int i = 0, j = 0, k = 0;
        while (leftArr.length > i && rightArr.length > j) {
            results[k++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (leftArr.length > i) {
            results[k++] = leftArr[i++];
        }
        while (rightArr.length > j) {
            results[k++] = rightArr[j++];
        }
        return results;

    }

}
