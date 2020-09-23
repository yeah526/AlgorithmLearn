package com.yeah.learn.algorithm;

import org.junit.Test;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * @see <a href="https://leetcode-cn.com/problems/reverse-integer/"></a>
 */
public class ReverseIntegerUnitTest {

    @Test
    public void main() {
        System.out.println("result = " + reverse(123));
    }

    /**
     * 思路图解：
     * https://pic.leetcode-cn.com/a161e3f0d41ad2866cb2bffe12084963b4e4c2e20086b71e377618d6b944fe4c-image.png
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        // 最终结果
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            int tmp = result * 10 + pop;
            if ((tmp - pop) / 10 != result) {
                // 通过tmp原路还原成result后，与result比较是否相等，如果不相等，则代表溢出，直接返回0
                return 0;
            }
            result = tmp;
            x /= 10;
        }
        return result;
    }

}