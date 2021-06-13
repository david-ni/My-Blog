package com.myblog.algorithm.leetcode;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumber{
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(){}
        public ListNode(int val){ this.val = val; }
        public ListNode(int val, ListNode next){ this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        boolean needIncre = false;
        ListNode result = new ListNode();
        ListNode resultNext = null;
        do{
            if(resultNext == null){
                resultNext = result;
            }else{
                resultNext.next = new ListNode();
                resultNext = resultNext.next;
            }
            int l1Vaue = l1 != null ? l1.val : 0;
            int l2Value = l2 != null ? l2.val : 0;
            int sum = l1Vaue + l2Value;

            if(needIncre) sum += 1;
            resultNext.val = sum%10;
            needIncre = sum >= 10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }while(l1 != null || l2 != null);

        if(needIncre) resultNext.next = new ListNode(1);

        return result;
    }
}
