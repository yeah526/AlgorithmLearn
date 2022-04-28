package com.yeah.learn.algorithm.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * @see <a href="https://leetcode-cn.com/problems/valid-parentheses/"></a>
 */
public class ValidParenthesesUnitTest {

    @Test
    public void main() {
        String input = "()[]{}";
        System.out.println("result = " + isValid(input));
    }

    /**
     * 从左到右遍历字符串的每个字符，遇到左括号压入栈，遇到右括号出一个栈顶元素，判断是否匹配：
     * ^如果不匹配则立刻返回不匹配
     * ^如果匹配则继续判断下一个符号
     * 最后如果栈是空的则表示匹配
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        // 保存左括号的栈
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;

                default:
                    if (stack.isEmpty() || map.get(c) != stack.pop()) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

}