package com.myblog.algorithm.sorting;

/**
 * 插入排序
 * 插入排序实现的步骤
 * 1. 找到待插入元素
 * 2. 遍历已排序数组，并将元素插入到合适的位置
 * @author David Wang <https://github.com/superTerrorist>
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
