package com.myblog.algorithm.leetcode;

/**
 * reverse link list
 * https://leetcode.cn/problems/reverse-linked-list/
 * @author David Wang <https://github.com/superTerrorist>
 */
public class N206ReverseLinkList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode pA = new ListNode(head.val,null); // 拷贝第一个元素
        ListNode pB = head.next;
        pA.next = null;
        while (pB != null){
            ListNode copy = pB;
            pB = pB.next;
            copy.next = pA;
            pA = copy;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        reverseList(node);
    }
}
