package com.myblog.algorithm.structure.linkedList;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
class ListNode{
    int val;
    ListNode next;
    ListNode prev;
    public ListNode(int val,ListNode prev,ListNode next){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

public class MyLinkedList {
    private ListNode head;
    private int size;

    public MyLinkedList() {}

    public int get(int index) {
        int i = 0;
        ListNode curNode = this.head;
        while(i < index){
            if(curNode == null) return -1;
            curNode = curNode.next;
            i++;
        }
        return curNode == null ? -1 : curNode.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val,null,this.head);
        if(this.head != null){
            this.head.prev = node;
            this.size++;
        }else{
            this.size = 1;
        }
        this.head = node;
    }

    public void addAtTail(int val) {
        ListNode curNode = this.head;
        if(curNode == null){
            addAtHead(val);
            return;
        }
        while(curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = new ListNode(val,curNode,null);;
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if(index <= 0){ // 如果index小于0，则在头部插入节点
            this.addAtHead(val);
            return;
        }

        if(index == this.size){
            addAtTail(val);
            return;
        }

        int i = 0;
        ListNode curNode = this.head;
        while(i < index){
            if(curNode == null) return; // 如果 index 大于链表长度，则不会插入节点
            curNode = curNode.next;
            i++;
        }

        ListNode prevNode = curNode.prev;
        ListNode node = new ListNode(val,prevNode,curNode);
        prevNode.next = node;
        curNode.prev = node;
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if(this.size == 0) return;
        int i = 0;
        ListNode curNode = this.head;
        while(i < index){
            curNode = curNode.next;
            if(curNode == null) return;
            i++;
        }
        if(curNode.prev == null){ // 如果是首节点
            this.head = curNode.next;
        }else{
            curNode.prev.next = curNode.next;
        }
    }
}
