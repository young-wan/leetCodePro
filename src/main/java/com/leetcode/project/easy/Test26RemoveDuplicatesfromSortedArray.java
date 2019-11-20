package com.leetcode.project.easy;

import java.util.Arrays;

/**
 * @title: leetCode
 * @author: Young
 * @desc: leetcode
 * @date: Created at 2019/11/20 2019 15:35
 * {@link} https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class Test26RemoveDuplicatesfromSortedArray {
    /*
    Given a sorted array nums, remove the duplicates in-place such that each element
    appear only once and return the new length.

    Do not allocate extra space for another array, you must do this by modifying the
    input array in-place with O(1) extra memory.

    Example 1:
    Given nums = [1,1,2],
    Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
    It doesn't matter what you leave beyond the returned length.

    Example 2:
    Given nums = [0,0,1,1,1,2,2,3,3,4],
    Your function should return length = 5, with the first five elements of nums
    being modified to 0, 1, 2, 3, and 4 respectively.
    It doesn't matter what values are set beyond the returned length.

    Clarification:
    Confused why the returned value is an integer but your answer is an array?

    Note that the input array is passed in by reference, which means modification to
    the input array will be known to the caller as well.

    Internally you can think of this:

    // nums is passed in by reference. (i.e., without making a copy)
    int len = removeDuplicates(nums);

    // any modification to nums in your function would be known by the caller.
    // using the length returned by your function, it prints the first len elements.
    for (int i = 0; i < len; i++) {
        print(nums[i]);
    }
    */

    public int removeDuplicates(int[] nums) {
        int res = nums.length == 0 ? 0 : 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[res] = nums[i + 1];
                res += 1;
            }
        }
        return res;
    }

    public int removeDuplicates2(int[] nums) {
        int res = nums.length == 0 ? 0 : 1;
        for (int n : nums) {
            //  和上一个值不同,则赋值,因为是已排序数组,只需要关注后续数据,无需考虑已比较过的数据
            if (n > nums[res - 1]) {
                nums[res++] = n;
            }
        }
        return res;
    }
}
