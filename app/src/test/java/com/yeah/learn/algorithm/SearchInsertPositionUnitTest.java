package com.yeah.learn.algorithm;

import org.junit.Test;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @see <a href="https://leetcode-cn.com/problems/search-insert-position/"></a>
 */
public class SearchInsertPositionUnitTest {

    @Test
    public void main() {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;
        System.out.println("result = " + searchInsert(nums, target));
    }

    /**
     * 二分法
     * <p>
     * 时间复杂度：O(logn)
     * 空间复杂度：O(?)
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int minIndex = 0;
        int maxIndex = nums.length - 1;
        if (target <= nums[minIndex]) {
            return 0;
        } else if (target == nums[maxIndex]) {
            return maxIndex;
        } else if (target > nums[maxIndex]) {
            return maxIndex + 1;
        }
        while (minIndex <= maxIndex) {
            int index = (maxIndex + minIndex) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] > target) {
                maxIndex = index - 1;
            } else {
                minIndex = index + 1;
            }
        }
        return minIndex;
    }

}