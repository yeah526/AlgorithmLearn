package com.yeah.learn.algorithm.easy;

import org.junit.Test;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @see <a href="https://leetcode-cn.com/problems/maximum-subarray/"></a>
 */
public class MaxSubArrayUnitTest {

    @Test
    public void main() {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("result = " + maxSubArray(input));
    }

    /**
     * 解题思路
     * TODO 未看明白题解
     * <p>
     * 时间复杂度：O(?)
     * 空间复杂度：O(?)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];

        return -1;
    }

}