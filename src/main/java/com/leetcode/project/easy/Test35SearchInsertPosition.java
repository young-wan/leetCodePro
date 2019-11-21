package com.leetcode.project.easy;

/**
 * @title: leetCode
 * @author: Young
 * @desc: leetcode
 * @date: Created at 2019/11/21 2019 9:37
 * {@link} https://leetcode.com/problems/search-insert-position/
 */
public class Test35SearchInsertPosition {
    /*
    Given a sorted array and a target value, return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Example 1:
    Input: [1,3,5,6], 5
    Output: 2

    Example 2:
    Input: [1,3,5,6], 2
    Output: 1

    Example 3:
    Input: [1,3,5,6], 7
    Output: 4

    Example 4:
    Input: [1,3,5,6], 0
    Output: 0
    */

    public int searchInsert(int[] nums, int target) {
        int poi = 0;
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] < target) {
                poi = i;
            } else {
                return ++poi;
            }
        }
        return 0;
    }

    public int searchInsert2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //  找出target最近的最大值并返回
            if (target <= nums[i]) {
                return i;
            }
        }
        //  target比nums都大,返回nums长度
        return nums.length;

    }

    public int searchInsert3(int[] nums, int target) {
        int low = 0, high = nums.length, mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2; // low<=mid, mid<high
            if (nums[mid] >= target) {
                high = mid; // high always decreases (even high-low==1)
            } else {
                low = mid + 1; // low always increases
            }
        }
        return low;

    }

}

