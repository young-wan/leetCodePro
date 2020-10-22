package com.leetcode.project.easy;

/**
 * @title: leetCode
 * @author: Young
 * @desc: leetcode
 * @date: Created at 2019/11/21 2019 11:15
 * {@link} https://leetcode.com/problems/maximum-subarray/
 */
public class Test_53_MaximumSubarray {
    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum.

    Example:
    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

    Follow up:
    If you have figured out the O(n) solution, try coding another solution using the divide and
    conquer approach, which is more subtle.
    */

    public int maxSubArray(int[] nums) {
        int max = 0;
        int dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //  dp为已经循环过的数据的和的最大值的存在
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(dp, max);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        //  最大值初始化为第一个数
        int max = nums[0];
        //  当前最大连续序列的和,初始化0
        int sum = 0;
        for (int n : nums) {
            if (sum > 0) {
                //  如果连续序列的和>0,有增益,则相加
                sum += n;
            } else {
                //  如果连续序列<=0,无增益效果,则舍弃,从当前位置重新开始(将连续序列和更新为当前值)
                sum = n;
            }
            //  每次比较当前最大值
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(test(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(test(new int[]{-2,-3}));
    }

    public static int test(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            }else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
