package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author wanyang
 * @description 堆排序
 * @date 2022/1/20
 */
public class HeapSort {

    /*
    堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。
    堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
    堆排序可以说是一种利用堆的概念来排序的选择排序。

    大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
    小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；
    大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
    小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]

    算法步骤：
    1. 将待排序序列构建成一个堆 H[0……n-1]，根据（升序降序需求）选择大顶堆或小顶堆；（一般升序采用大顶堆，降序采用小顶堆)。
    2. 把堆首（最大值）和堆尾互换；
    3. 把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
    4. 重复步骤 2，直到堆的尺寸为 1。

    时间复杂度：
     O(nlogn)。
     */

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(heapSort(IntegerUtils.ints)));
        System.out.println(Arrays.toString(heap3(IntegerUtils.ints)));

    }

    private static int[] heapSort(int[] arr) {
        // 1.构造大顶堆，这里其实就是把待排序序列，变成一个大顶堆结构的数组
        int len = arr.length;
        // 从最后一个非叶子节点开始向前遍历，调整节点性质，使之成为大顶堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            heapify(arr, i, len);
        }

        // 2.调整堆结构+交换堆顶元素与末尾元素
        for (int i = len - 1; i > 0; i--) {
            // 将堆顶元素与末尾元素进行交换
            swap(arr, 0, i);
            // 重新对堆进行调整
            heapify(arr, 0, i);
        }
        return arr;
    }

    /**
     * 调整堆
     *
     * @param arr
     * @param i
     * @param len
     */
    private static void heapify(int[] arr, int i, int len) {
        // 先根据堆性质，找出它左右节点的索引
        // 默认当前节点（父节点）是最大值。
        int large = i;
        // 左节点
        int left = i * 2 + 1;
        // 右节点
        int right = i * 2 + 2;

        // 如果左节点存在，且比父节点大，更新最大值的索引
        if (left < len && arr[left] > arr[large]) {
            large = left;
        }

        // 如果右节点存在，且比父节点大，更新最大值的索引
        if (right < len && arr[right] > arr[large]) {
            large = right;
        }

        // 如果最大值不是当前非叶子节点的值，那么就把当前节点和最大值的子节点值互换
        if (large != i) {
            // 交换数据
            swap(arr, i, large);
            // 因为互换之后，子节点的值变了，如果该子节点也有自己的子节点，仍需要再次调整。
            heapify(arr, large, len);
        }
    }

    /**
     * 交换
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private static int[] heap2(int[] arr) {

        // 1.构建大顶堆
        int len = arr.length;
        // 2.从最后一个非叶子节点开始，往前遍历，构建
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapy2(arr, i, len);
        }

        // 3.交换堆顶和堆尾的数据，并重新调整堆
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapy2(arr, 0, i);
        }


        return arr;
    }

    private static void heapy2(int[] arr, int i, int len) {
        // 默认当前节点为最大值
        int large = i;
        // 找出左右节点
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < len && arr[left] > arr[large]) {
            // 更新最大值索引
            large = left;
        }

        if (right < len && arr[right] > arr[large]) {
            large = right;
        }

        // 最大值索引发生变化，则需要交换数据，并重新调整堆
        if (large != i) {
            swap(arr, i, large);
            heapy2(arr, large, len);
        }
    }


    public static int[] heap3(int[] arr) {
        // 构建大顶堆
        int len = arr.length;

        for (int i = len / 2 - 1; i >= 0 ; i--) {
            heapy3(arr, i, len);
        }

        for (int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapy3(arr, 0, i);
        }

        return arr;
    }

    private static void heapy3(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int large = i;

        if (left < len && arr[left] > arr[large]) {
            large = left;
        }

        if (right < len && arr[right] > arr[large]) {
            large = right;
        }

        if (large != i) {
            swap(arr, i, large);
            heapy3(arr, large, len);
        }

    }
}
