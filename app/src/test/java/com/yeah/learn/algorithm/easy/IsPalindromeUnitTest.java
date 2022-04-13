package com.yeah.learn.algorithm.easy;

import org.junit.Test;

/**
 * 判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * @see <a href="https://leetcode-cn.com/problems/palindrome-number/"></a>
 */
public class IsPalindromeUnitTest {

    @Test
    public void main() {
        System.out.println("result = " + isPalindrome(121));
    }

    /**
     * 跟整数反转的思路差不多，但是只反转1半的数，然后拿这一半的数与剩下未反转的数进行比较
     * <p>
     * 时间复杂度：O(log n)
     * 空间复杂度：O(1)
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            // 负数或者0结尾的正数直接判断为非回文数
            return false;
        }
        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return reverseNum == x || reverseNum / 10 == x;
    }

}