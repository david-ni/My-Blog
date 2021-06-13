# 排序算法

> 排序动画：https://visualgo.net/en

| 排序算法 | 平均时间复杂度   | 最好情况         | 最坏情况         | 空间复杂度 | 稳定性 |
| -------- | ---------------- | ---------------- | ---------------- | ---------- | ------ |
| 冒泡排序 | O(n<sup>2</sup>) | O(n)             | O(n<sup>2</sup>) | O(1)       | 稳定   |
| 选择排序 | O(n<sup>2</sup>) | O(n<sup>2</sup>) | O(n<sup>2</sup>) | O(1)       | 稳定   |
| 插入排序 | O(n<sup>2</sup>) | O(n)             | O(n<sup>2</sup>) | O(1)       | 稳定   |
| 希尔排序 | O(n^(1.3~2))     |                  |                  |            |        |

## 冒泡排序

冒泡排序（Bubble Sort）是计算机领域比较简单的排序算法

### 算法步骤

![BubbleSort_case](Assets/Sorting/bubble-sort.gif)

1. 比较相邻元素的大小，如果前一个元素比后一个元素大，则交换它们；

2. 对每一对相邻元素做同样的工作，从开始第一对元素到结尾的最后一对元素。最终最后位置的元素就是最大

   值。

### 算法实现

```java
// java实现
public class BubbleSort implements ISort<Integer>{
    @Override
    public void sort(Comparable<Integer>[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(isGreater(array[j],array[j+1])){
                    swap(array,j,j+1);
                }
            }
        }
    }
}
```

### 算法复杂度

平均情况下，冒泡排序的时间复杂度是O(n<sup>2</sup>)，如果数据量太大，冒泡排序并不合适。

## 选择排序

### 算法步骤

![selection-sort](Assets/Sorting/selection-sort.gif)

1. 在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
2. 从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
3. 重复第二步，直到所有元素均排序完毕

### 算法实现

```java
// java
public class SelectionSort implements ISort<Integer>{
    @Override
    public void sort(Comparable<Integer>[] array){
        for(int i = 0; i < array.length; i++){
            int minIdex = i;
            for(int j = i + 1; j < array.length; j++){
                if(isGreater(array[i],array[j])) minIdex = j;
            }
            if(minIdex != i) swap(array,minIdex,i);
        }
    }
}
```

### 算法复杂度

平均情况下，选择排序的时间复杂度是O(n<sup>2</sup>)，但是相对于冒泡排序而言，选择排序的效率更高一些（每次遍历最多只交换一次）。

## 插入排序

### 算法步骤

<img src="Assets/Sorting/Insertion-sort.gif" alt="insertion-sort" style="zoom: 50%;" />

1. 插入排序把序列分成已排序和未排序两部分
2. 取出未排序部分的第一个元素，作为待插入元素
3. 倒序遍历已排序部分的元素，依次和待插入的元素进行比较，如果待插入元素小于已排序元素则交换

![image-20210613162649966](Assets/Sorting/image-20210613162649966.png)

### 算法实现

```java
/**
 * 插入排序
 * 插入排序实现的步骤
 * 1. 找到待插入元素
 * 2. 遍历已排序数组，并将元素插入到合适的位置
 */
public class InsertionSort implements ISort<Integer>{
    @Override
    public void sort(Comparable<Integer>[] array){
        // 1. 从未排序数组中找到待插入元素
        for(int i = 0; i < array.length; i++){
            // 倒序遍历已排序数组
            for(int j = i - 1; j >= 0; j--){
                if(isGreater(array[j + 1],array[j])) break;
                swap(array,j+1,j);
            }
        }
    }
}
```

### 算法复杂度

插入排序的时间复杂度是O(n<sup>2</sup>)，如果大多数元素已排序，或者元素量相对较小的情况下，插入排序比较高效。

## 希尔排序

## 归并排序

## 快速排序

## 参考

