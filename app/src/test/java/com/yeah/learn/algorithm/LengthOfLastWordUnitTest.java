package com.yeah.learn.algorithm;

import org.junit.Test;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * <p>
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 *
 * @see <a href="https://leetcode-cn.com/problems/length-of-last-word/"></a>
 */
public class LengthOfLastWordUnitTest {

    @Test
    public void main() {
        String input = "h world";
        System.out.println("result = " + lengthOfLastWord(input));
    }

    /**
     * 从后往前遍历的方法
     * <p>
     * 时间复杂度：O(s)
     * 空间复杂度：O(1)
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int result = 0;
        for (int i = (s.length() - 1); i >= 0; i--) {
            if (' ' == s.charAt(i)) {
                if (result != 0) {
                    break;
                }
            } else {
                result++;
            }
        }
        return result;
    }

}