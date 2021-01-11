package com.leetcode.catagory.Array;

/**
 * @Author young
 * @Date 2020/12/23 14:08
 * @Desc
 **/
public class Test_26 {
    /**
     * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     *
     * Clarification:
     *
     * Confused why the returned value is an integer but your answer is an array?
     *
     * Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
     *
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4]
     */

    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 1;
        int sum = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                prev = nums[i];
                sum++;
                nums[index++] = nums[i];
            }
        }
        return sum;

//        int i = 0, j = 0;
//        while (j < nums.length) {
//            if (nums[i] == nums[j]) {
//                j++;
//            } else {
//                nums[++i] = nums[j++];
//            }
//        }
//        return i++;
    }
}
