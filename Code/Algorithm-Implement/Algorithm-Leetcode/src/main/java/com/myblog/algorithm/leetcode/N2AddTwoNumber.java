package com.myblog.algorithm.leetcode;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class N2AddTwoNumber {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(){}
        public ListNode(int val){ this.val = val; }
        public ListNode(int val, ListNode next){ this.val = val; this.next = next; }
    }

    /**
     * 解法一： 递归
     **/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null) return null;

        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;
        int val = val1 + val2;

        ListNode next1 = l1 != null ? l1.next : null;
        ListNode next2 = l2 != null ? l2.next : null;

        boolean needPlus = val > 9;

        if(needPlus){
            if(next1 != null){
                next1.val = next1.val + 1;
            }else if(next2 != null){
                next2.val = next2.val + 1;
            }else{
                next1 = new ListNode(1);
            }
        }

        ListNode node = new ListNode(val%10);
        node.next = addTwoNumbers(next1, next2);

        return node;
    }
}
