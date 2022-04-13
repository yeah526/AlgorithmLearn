package com.yeah.learn.algorithm.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/"></a>
 */
public class LongestSubstringWithoutRepeatingCharsUnitTest {

    @Test
    public void main() {
        String input = "abcabcbb";
        System.out.println("result = " + lengthOfLongestSubstring(input));
    }

    /**
     * 暴力解法
     * <p>
     * 时间复杂度：O(2^s)
     * 空间复杂度：O(s)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int sLength = s.length();
        int maxLength = 0;
        int cursor = 0;
        Character curChar;
        Set<Character> charSet = new HashSet<>();
        // 当当前最长子串长度 小于 移动指针到字符串尾的长度时，表示后面还可能有更长的子串
        while (maxLength < (sLength - cursor)) {
            for (int i = cursor; i < sLength; i++) {
                curChar = s.charAt(i);
                if (!charSet.add(curChar)) {
                    maxLength = charSet.size() > maxLength ? charSet.size() : maxLength;
                    cursor += 1;
                    charSet.clear();
                    break;
                }
            }
        }
        return maxLength;
    }

    /**
     * 滑动窗口
     * <p>
     * 时间复杂度：O(s)
     * 空间复杂度：O(∣Σ∣)其中 Σ 表示字符集（即字符串中可以出现的字符），∣Σ∣ 表示字符集的大小。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int sLength = s.length();
        int maxLength = 0;
        int leftPos = 0; //窗口左边界
        Character curChar;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int rightPos = 0; rightPos < sLength || maxLength < (sLength - leftPos); rightPos++) {
            curChar = s.charAt(rightPos);
            Integer previous = charMap.put(curChar, rightPos);
            if (previous != null) {
                leftPos = Math.max(leftPos, previous + 1);
            }
            maxLength = Math.max(maxLength, rightPos - leftPos + 1);
        }
        return maxLength;
    }

}