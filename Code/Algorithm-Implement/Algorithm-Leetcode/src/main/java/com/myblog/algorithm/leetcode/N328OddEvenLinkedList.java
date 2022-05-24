package com.myblog.algorithm.leetcode;

/**
 * 328. Odd Even Linked List
 * https://leetcode.cn/problems/odd-even-linked-list/
 * @author David Wang <https://github.com/superTerrorist>
 */
public class N328OddEvenLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 解法一：
     * 假设有链表 1->2->3->4->5->6->7->....->n
     */
    public static ListNode solution1(ListNode head){
        if(head == null) return head;
        ListNode oddList = head; // 奇数链表
        ListNode evenListHead = new ListNode(0);
        ListNode evenList = evenListHead; // 偶数链表
        while (oddList.next != null){
            evenList = evenList.next = new ListNode(oddList.next.val);
            oddList.next = oddList.next.next;
        }
        oddList.next = evenListHead.next;
        return head;
    }

    public static void main(String[] args) {
        solution1(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
    }
}
