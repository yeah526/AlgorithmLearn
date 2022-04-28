package com.yeah.learn.algorithm.medium;

import org.junit.Test;

/**
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * 注意：整数序列中的每一项将表示为一个字符串。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 * <p>
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 *
 * @see <a href="">https://leetcode-cn.com/problems/count-and-say/</a>
 */
public class CountNSayUnitTest {

    @Test
    public void main() {
        System.out.println("result = " + countAndSay(30));
    }

    /**
     * 暴力解法
     * <p>
     * 时间复杂度：O(?)
     * 空间复杂度：O(?)
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        return recursive(1, n, "1");
    }

    public String recursive(int curCount, int maxCount, String input) {
        if (curCount >= maxCount) {
            return input;
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder();
        int lastIndex = 0;
        for (int i = 1; i < length; i++) {
            if (input.charAt(i) != input.charAt(lastIndex)) {
                sb.append(i - lastIndex);
                sb.append(input.charAt(lastIndex));
                lastIndex = i;
            }
        }
        if (lastIndex == length - 1) {
            sb.append(1);
        } else {
            sb.append(length - lastIndex);
        }
        sb.append(input.charAt(lastIndex));
        return recursive(curCount + 1, maxCount, sb.toString());
    }

}