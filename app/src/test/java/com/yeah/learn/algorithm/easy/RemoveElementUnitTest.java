package com.yeah.learn.algorithm.easy;

import org.junit.Test;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * @see <a href="https://leetcode-cn.com/problems/remove-element/"></a>
 */
public class RemoveElementUnitTest {

    @Test
    public void main() {
        int[] nums = new int[]{2, 2, 3};
        int val = 2;
        System.out.println("result = " + removeElement(nums, val));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i] + ",");
        }
        System.out.println("nums = " + sb.toString());
    }

    /**
     * 头尾指针法
     * 顺序：
     * 1、头指针从数组的头部向尾部挪动，遇到val值则停下
     * 2、尾指针从数组的尾部向头部挪动，遇到非val值，则把尾指针的值赋给头指针
     * 3、头指针重新挪动，如此循环直至头尾指针把数组都遍历完全
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] != val) {
                i++;
            } else if (nums[j] == val) {
                j--;
            } else {
                nums[i] = nums[j];
                i++;
                j--;
            }
        }
        return i;
    }

}