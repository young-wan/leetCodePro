package com.leetcode.catagory.Array;

/**
 * @Author young
 * @Date 2020/12/18 15:34
 * @Desc
 **/
public class Test_11 {

    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
     * Find two lines, which, together with the x-axis forms a container,
     * such that the container contains the most water.
     * <p>
     * Notice that you may not slant the container.
     * <p>
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * <p>
     * Input: height = [4,3,2,1,4]
     * Output: 16
     */

    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
