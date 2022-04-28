package com.yeah.learn.algorithm.medium;

import org.junit.Test;

/**
 * 盛最多水的容器
 * <p>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * <p>
 * 示例 1：
 * https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 提示：
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 *
 * @see <a href="https://leetcode-cn.com/problems/container-with-most-water/"></a>
 */
public class ContainerWithMostWaterUnitTest {

    @Test
    public void main() {
        System.out.println("result = " + maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println("result = " + maxArea(new int[]{1, 1}));
    }

    /**
     * 双指针法
     * 头尾各一个指针，不断往中间靠
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int head = 0;
        int tail = height.length - 1;
        int tmp, result = 0;
        while (head < tail) {
            tmp = Math.min(height[head], height[tail]) * (tail - head);
            if (tmp > result) {
                result = tmp;
            }

            if (height[head] > height[tail]) {
                --tail;
            } else {
                ++head;
            }
        }
        return result;
    }

}