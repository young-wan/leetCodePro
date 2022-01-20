package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author wanyang
 * @description 计数排序
 * @date 2022/1/20
 */
public class CountingSort {

    /*
    计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。

    算法步骤：
    1. 找出待排序的数组中最大和最小的元素；
    2. 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
    3. 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
    4. 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
     */

    public static void main(String[] args) {

        System.out.println(Arrays.toString(countingSort(IntegerUtils.ints)));

    }

    private static int[] countingSort(int[] arr) {
        // 找到最大值
        int maxValue = getMax(arr);
        // 构建数组长度
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        // 统计数组中的元素出现的次数，放入对应的bucket位置
        for (int value : arr) {
            // bucket记录的是每个元素出现的次数
            bucket[value]++;
        }

        // 此时的bucket，已经是按照大小顺序排列好的数组，所以直接从0开始取即可
        // 遍历bucket，如果有值，则放入arr中，并且bucket中的值减一
        int index = 0;
        for (int i = 0; i < bucketLen; i++) {
            // 如果有值，则放入arr中,值就是i
            while (bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
        }
        return arr;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

}
