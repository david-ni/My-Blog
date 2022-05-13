# 二分查找

二分查找（Binary Search）算法，也叫折半查找算法。二分查找针对的是一个**有序**的数据集合，每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半，直到找到要查找的元素。

> **算法复杂度**：
>
> - 时间复杂度：O(logn)，其中 n 是数组的长度。
> - 空间复杂度：O(1)。

![binary-and-linear-search-animations](./assets/Binary-Search/binary-and-linear-search-animations.gif)

## 代码实现

> 题目：给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
>
> 来源：[Leetcode Binary Search](https://leetcode.cn/problems/binary-search/)

```java
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int minIndex = -1;
        do{
            minIndex = startIndex + (endIndex - startIndex)/2;
            if(target > nums[minIndex]){
                startIndex = minIndex;
            }else{
                endIndex = minIndex;
            }
            if(nums[startIndex] == target) return startIndex;
            if(nums[endIndex] == target) return endIndex;
        }while (startIndex != (endIndex - 1) && startIndex != endIndex);
        return -1;
    }
}
```

