package com.myblog.algorithm.sorting;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
public interface ISort<T>{

    void sort(Comparable<T>[] array);

    default boolean isGreater(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }

    default void swap(Comparable<T>[] array,int fromIndex,int toIndex){
        Comparable temp = array[toIndex];
        array[toIndex] = array[fromIndex];
        array[fromIndex] = temp;
    }
}
