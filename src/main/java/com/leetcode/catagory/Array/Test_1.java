package com.leetcode.catagory.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author young
 * @Date 2020/12/18 9:53
 * @Desc
 **/
public class Test_1 {
    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * You can return the answer in any order.
     */

    public static void main(String[] args) {
        twoSum(new int[]{3, 3}, 6);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (map.get(find) != null) {
                return new int[]{map.get(find), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
