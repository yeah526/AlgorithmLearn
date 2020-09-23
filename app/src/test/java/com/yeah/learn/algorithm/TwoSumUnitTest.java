package com.yeah.learn.algorithm;

import org.junit.Test;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @see <a href="https://leetcode-cn.com/problems/two-sum/"></a>
 */
public class TwoSumUnitTest {

    @Test
    public void main() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 26;
        int[] result = twoSum(nums, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");

        result = twoSum2(nums, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    /**
     * 暴力解法
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = (i + 1); j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    /**
     * 利用HashMap的解法
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int desire;
        for (int i = 0; i < nums.length; i++) {
            desire = target - nums[i];
            if (map.containsKey(desire)) {
                return new int[]{map.get(desire), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

}