package com.yeah.learn.algorithm.easy;

import org.junit.Test;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @see <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/"></a>
 */
public class MergeTwoSortedListsUnitTest {

    @Test
    public void main() {
//        int input = 121;
//        System.out.println("result = " + isPalindrome(input));
    }

    /**
     * 自己实现的暴力解法，缺点：
     * 1.没有引入哑节点
     * 2.外循环的边界条件判断比较差，导致内部的判断分支较多
     * <p>
     * 时间复杂度：O(n+m) n是l1的长度，m是l2的长度
     * 空间复杂度：O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode headNode, preNode;
        if (l1.val <= l2.val) {
            headNode = preNode = l1;
            l1 = l1.next;
        } else {
            headNode = preNode = l2;
            l2 = l2.next;
        }
        while (preNode != null) {
            if (l1 == null) {
                preNode.next = l2;
                preNode = null;
            } else if (l2 == null) {
                preNode.next = l1;
                preNode = null;
            } else if (l1.val > l2.val) {
                preNode.next = l2;
                l2 = l2.next;
                preNode = preNode.next;
            } else {
                preNode.next = l1;
                l1 = l1.next;
                preNode = preNode.next;
            }
        }
        return headNode;
    }

    /**
     * 官方暴力解法，引入哑节点
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
     * <p>
     * 时间复杂度：O(n+m) n是l1的长度，m是l2的长度
     * 空间复杂度：O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummyNode, preNode;
        dummyNode = preNode = new ListNode(0);
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                preNode.next = l1;
                l1 = l1.next;
            } else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        preNode.next = l1 == null ? l2 : l1;
        return dummyNode.next;
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}