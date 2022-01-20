package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author wanyang
 * @description 桶排序
 * @date 2022/1/20
 */
public class BucketSort {

    /*
    桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。为了使桶排序更加高效，我们需要做到这两点：
    1. 在额外空间充足的情况下，尽量增大桶的数量
    2. 使用的映射函数能够将输入的 N 个数据均匀的分配到 K 个桶中
    同时，对于桶中元素的排序，选择何种比较排序算法对于性能的影响至关重要。

    算法步骤：
    1. 设置一个定量的数组当作空桶；
    2. 遍历输入数据，并且把数据一个一个放到对应的桶里去；
    3. 对每个不是空的桶进行排序；
    4. 从不是空的桶里把排好序的数据拼接起来。

    重点
    1. 如何确定桶的个数  (maxValue - minValue) / len + 1
    2. 遍历时当前元素在桶的下表位置  (value - minValue) / len
     */

    public static void main(String[] args) {

        System.out.println(Arrays.toString(bucketSort(IntegerUtils.ints)));

    }

    private static int[] bucketSort(int[] arr) {

        int len = arr.length;

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }
        // 确定桶的数量
        int bucketLen = (maxValue - minValue) / len + 1;

        // 构造一个二维数组存放数据
        int[][] buckets = new int[bucketLen][0];

        // 遍历输入元素，并根据规则放入对应的桶里
        for (int value : arr) {
            int index = (value - minValue) / len;
            buckets[index] = insertValue(buckets[index], value);
        }

        // 从bucket中遍历读取数据放入arr中
        int index = 0;
        for (int[] bucket : buckets) {
            if (bucket.length > 0) {
                for (int value : bucket) {
                    arr[index++] = value;
                }
            }
        }

        return arr;
    }

    /**
     * 插入元素时排序
     *
     * @param bucket
     * @param value
     * @return
     */
    private static int[] insertValue(int[] bucket, int value) {
        int[] newBucket = new int[bucket.length + 1];
        newBucket[newBucket.length - 1] = value;
        for (int i = newBucket.length - 1; i > 0; i--) {
            newBucket[i - 1] = bucket[i - 1];
            if (newBucket[i - 1] > newBucket[i]) {
                int tmp = newBucket[i];
                newBucket[i] = newBucket[i - 1];
                newBucket[i - 1] = tmp;
            }
        }
        return newBucket;
    }

}
