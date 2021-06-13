package com.myblog.algorithm.sorting;

/**
 * 选择排序
 * @author David Wang <https://github.com/superTerrorist>
 */
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
