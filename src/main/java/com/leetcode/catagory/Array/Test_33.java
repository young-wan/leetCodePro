package com.leetcode.catagory.Array;

/**
 * @Author young
 * @Date 2020/12/23 14:25
 * @Desc
 **/
public class Test_33 {
    /**
     *You are given an integer array nums sorted in ascending order, and an integer target.
     *
     * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     *
     * If target is found in the array return its index, otherwise, return -1.
     *
     * Example 1:
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     *
     * Example 2:
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     *
     * Example 3:
     * Input: nums = [1], target = 0
     * Output: -1
     */

    public static void main(String[] args) {

    }

    /**
     * not good
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
