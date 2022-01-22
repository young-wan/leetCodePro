package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author wanyang
 * @description 基数排序
 * @date 2022/1/20
 */
public class RadixSort {

    /*
    基数排序是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
    由于整数也可以表达字符串（比如名字或日期）和特定格式的浮点数，所以基数排序也不是只能使用于整数。

    算法步骤：
    1. 取得数组中的最大数，并取得位数；
    2. arr为原始数组，从最低位开始取每个位组成radix数组；
    3. 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(radixSort(IntegerUtils.ints)));
    }

    private static int[] radixSort(int[] arr) {
        // 1. 取得数组中的最大数
        int maxValue = getMax(arr);

        // 1. 并取得位数；
        int pos = 0;
        while (maxValue > 0) {
            maxValue /= 10;
            pos++;
        }

        // 构造radix数组
        int[] radix;

        // 遍历pos次,每次取当前位的值
        for (int i = 1; i <= pos; i++) {
            radix = new int[10];
            for (int j = 0; j < arr.length; j++) {
                // 获取当前位的取模值,放入对应radix数组中
                int num = getNum(i, arr[j]);
                radix[num]++;
            }
            // 两两累加，得到每一个位置上及其之前的元素个数和
            for (int j = 1; j < radix.length; j++) {
                radix[j] = radix[j - 1] + radix[j];
            }

            int index;

            // 构造临时数组，存放排序后元素
            int[] tmpArr = new int[arr.length];

            // 从后往前遍历
            for (int j = arr.length - 1; j >= 0; j--) {
                // 根据取模的值，拿到对应的数组下标
                int num = getNum(i, arr[j]);
                index = --radix[num];
                tmpArr[index] = arr[j];
            }
            arr = tmpArr;
        }

        return arr;
    }

    /**
     * 获取最大值
     *
     * @param arr
     * @return
     */
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    /**
     * 获取当前位的取模值
     *
     * @param count
     * @param value
     * @return
     */
    private static int getNum(int count, int value) {
        // 先 /=10 前n次
        for (int i = 0; i < count - 1; i++) {
            value /= 10;
        }
        // 最后 %= 10
        value %= 10;
        return value;
    }

}
