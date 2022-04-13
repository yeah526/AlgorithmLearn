package com.yeah.learn.algorithm.easy;

import org.junit.Test;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-common-prefix/"></a>
 */
public class LongestCommonPrefixUnitTest {

    @Test
    public void main() {
        String[] strs = new String[]{"flower", "flow", "flight"};
//        String[] strs = new String[]{"dog", "racecar", "car"};
//        String[] strs = new String[]{"ab", "cab"};
        System.out.println("result = " + longestCommonPrefix(strs));
    }

    /**
     * 水平扫描法：
     * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/
     * <p>
     * 时间复杂度：O(S)，S是所有字符串中字符数量的总和
     * 空间复杂度：O(1)
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 最终结果
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (result.isEmpty()) {
                    return "";
                }
            }
        }
        return result;
    }

}