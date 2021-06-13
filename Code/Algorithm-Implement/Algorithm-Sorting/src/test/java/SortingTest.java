import com.myblog.algorithm.sorting.BubbleSort;
import com.myblog.algorithm.sorting.SelectionSort;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
public class SortingTest{
    public static void main(String[] args){
        Integer[] array = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();

        selectionSort.sort(array);

        System.out.println(array);
    }
}
