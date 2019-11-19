package com.leetcode.project.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @title: leetCode
 * @author: Young
 * @desc: leetcode
 * @date: Created at 2019/11/19 2019 11:43
 * {@link} https://leetcode.com/problems/two-sum/
 */
public class Test1TwoSum {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];
            if (Objects.isNull(map.get(diff))) {
                map.put(nums[i], i);
            } else {
                res[0] = map.get(diff);
                res[1] = i;
                return res;
            }
        }
        return res;
    }

    /**
     在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
     如果它存在，那我们已经找到了对应解，并立即将其返回。

     复杂度分析：

     时间复杂度：O(n)，
     我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。

     空间复杂度：O(n)，
     所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。
     */
}
