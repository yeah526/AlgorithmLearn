package com.yeah.learn.algorithm.easy;

import org.junit.Test;

/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @see <a href="https://leetcode-cn.com/problems/implement-strstr/"></a>
 */
public class StrStrUnitTest {

    @Test
    public void main() {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println("result = " + strStr(haystack, needle));
    }

    /**
     * 暴力解法(双指针法)
     * 这题是自己想的，类似官方解法的方法二：
     * https://leetcode-cn.com/problems/implement-strstr/solution/shi-xian-strstr-by-leetcode/
     * <p>
     * 时间复杂度：O((N−L)L)
     * 空间复杂度：O(1)
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int needleLength = needle.length();
        int hayStackIndex = 0;
        int maxHayStackStartIndex = haystack.length() - needleLength;
        while (hayStackIndex <= maxHayStackStartIndex) {
            int i = 0;
            while (i < needleLength) {
                if (haystack.charAt(hayStackIndex + i) != needle.charAt(i)) {
                    break;
                }
                ++i;
            }
            if (i == needleLength) {
                return hayStackIndex;
            } else {
                hayStackIndex++;
            }
        }
        return -1;
    }

}