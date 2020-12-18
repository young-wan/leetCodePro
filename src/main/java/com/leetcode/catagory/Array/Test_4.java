package com.leetcode.catagory.Array;

/**
 * @Author young
 * @Date 2020/12/18 11:13
 * @Desc
 **/
public class Test_4 {
    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     * <p>
     * Follow up: The overall run time complexity should be O(log (m+n)).
     */

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 5, 6, 10};
        int[] nums2 = new int[]{2, 4, 8};
        findMedianSortedArrays(nums1, nums2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] res = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        while (i < m) {
            res[k++] = nums1[i++];
        }
        while (j < n) {
            res[k++] = nums2[j++];
        }
        int sum = m + n;
        if (sum % 2 == 0) {
            return (res[sum / 2] + res[sum / 2 - 1]) / 2.0;
        }else {
            return res[sum / 2];
        }
    }
}
