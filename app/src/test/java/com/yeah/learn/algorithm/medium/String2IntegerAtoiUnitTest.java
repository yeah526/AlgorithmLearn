package com.yeah.learn.algorithm.medium;

import org.junit.Test;

/**
 * 字符串转换整数 (atoi)
 * <p>
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数 myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31 − 1 的整数应该被固定为 2^31 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * <p>
 * 示例1：
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 * ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * ^
 * 第 3 步："42"（读入 "42"）
 * ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-2^31, 2^31 - 1] 内，最终结果为 42 。
 * <p>
 * 示例2：
 * 输入：s = "   -42"
 * 输出：-42
 * 解释：
 * 第 1 步："   -42"（读入前导空格，但忽视掉）
 * ^
 * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 * ^
 * 第 3 步："   -42"（读入 "42"）
 * ^
 * 解析得到整数 -42 。
 * 由于 "-42" 在范围 [-2^31, 2^31 - 1] 内，最终结果为 -42 。
 * <p>
 * 示例3：
 * 输入：s = "4193 with words"
 * 输出：4193
 * 解释：
 * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
 * ^
 * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * ^
 * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
 * ^
 * 解析得到整数 4193 。
 * 由于 "4193" 在范围 [-2^31, 2^31 - 1] 内，最终结果为 4193 。
 * <p>
 * 提示：
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 *
 * @see <a href="https://leetcode-cn.com/problems/string-to-integer-atoi/"></a>
 */
public class String2IntegerAtoiUnitTest {

    @Test
    public void main() {
        System.out.println("result = " + myAtoi("42"));
        System.out.println("result = " + myAtoi("   -42"));
        System.out.println("result = " + myAtoi("4193 with words"));
        System.out.println("result = " + myAtoi("words and 987"));
        System.out.println("result = " + myAtoi("2147483648"));
        System.out.println("result = " + myAtoi("-21474836461"));
        System.out.println("result = " + myAtoi("+-12"));
        System.out.println("result = " + myAtoi("+12"));
        System.out.println("result = " + myAtoi("  0000000000012345678"));
        System.out.println("result = " + myAtoi("00000-42a1234"));
        System.out.println("result = " + myAtoi("20000000000000000000"));
        System.out.println("result = " + myAtoi("-000000000000001"));
    }

    /**
     * 暴力解法
     * 使用long来辅助判断是否int越界
     * <p>
     * 时间复杂度：O(s)
     * 空间复杂度：O(1)
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        long result = 0;
        Boolean isMinus = null;
        char c;
        boolean isBreak = false;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
                case ' ':
                    if (isMinus != null) isBreak = true;
                    break;

                case '+':
                    if (isMinus != null) isBreak = true;
                    else isMinus = false;
                    break;
                case '-':
                    if (isMinus != null) isBreak = true;
                    else isMinus = true;
                    break;

                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (isMinus == null) isMinus = false;
                    result = result * 10 + (((int) c) - '0');
                    if (isMinus) {
                        if (-result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                    } else {
                        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                    }
                    break;

                default:
                    isBreak = true;
                    break;
            }
            if (isBreak) break;
        }

        if (isMinus == null) {
            return (int) result;
        } else if (isMinus) {
            return (int) -result;
        } else {
            return (int) result;
        }
    }

}