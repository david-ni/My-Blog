# 链表

链表是一种线性数据结构，常用的链表有单向链表、双向链表等

![linked-list-1](/Users/david/Desktop/Github/My-Blog/Article/Computer-ABC/Algorithm/assets/Linked-List/linked-list-1.jpeg)

```java
// 链表的数据结构
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
```

## 双指针技巧

### 链表是否有环

> [环型链表](https://leetcode.cn/problems/linked-list-cycle/)



### 环型链表的入口

> [环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/)

## 扩展资料

1. [Floyd判圈算法（龟兔赛跑算法）](https://zh.m.wikipedia.org/zh-hans/Floyd%E5%88%A4%E5%9C%88%E7%AE%97%E6%B3%95)



