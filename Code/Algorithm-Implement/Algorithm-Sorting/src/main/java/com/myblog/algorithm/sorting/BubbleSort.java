package com.myblog.algorithm.sorting;

/**
 * 冒泡排序
 *
 * @author David Wang <https://github.com/superTerrorist>
 */
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
