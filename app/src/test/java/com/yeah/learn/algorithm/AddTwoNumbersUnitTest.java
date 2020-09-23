package com.yeah.learn.algorithm;

import org.junit.Test;

import java.util.Random;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @see <a href="https://leetcode-cn.com/problems/add-two-numbers/"></a>
 */
public class AddTwoNumbersUnitTest {

    @Test
    public void main() {
        Random random = new Random(System.currentTimeMillis());
        ListNode l1 = new ListNode(Math.abs(random.nextInt()) % 10);
        ListNode tmp = l1;
        for (int i = 0; i < 5; i++) {
            tmp.next = new ListNode(Math.abs(random.nextInt()) % 10);
            tmp = tmp.next;
        }
        ListNode l2 = new ListNode(Math.abs(random.nextInt()) % 10);
        tmp = l2;
        for (int i = 0; i < 3; i++) {
            tmp.next = new ListNode(Math.abs(random.nextInt()) % 10);
            tmp = tmp.next;
        }

        printListNode(l1);
        printListNode(l2);
        ListNode result = addTwoNumbers(l1, l2);
        printListNode(result);
    }

    private void printListNode(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            sb.append(" -> ");
            node = node.next;
        }
        System.out.println(sb.toString());
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 从低位开始各自相加，并用一个进位标志判断下一位数相加时是否需要+1
     * <p>
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x;
        ListNode head = new ListNode(0), tail = head;
        // 是否需要进位
        boolean needAddOne = false;
        // 进入循环
        while (needAddOne || (l1 != null && l2 != null)) {
            x = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (needAddOne ? 1 : 0);

            tail.next = new ListNode(x % 10);
            tail = tail.next;

            needAddOne = (x != tail.val);

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return head.next;
    }

}