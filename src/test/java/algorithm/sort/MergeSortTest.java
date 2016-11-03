package algorithm.sort;

import org.junit.Test;

/**
 * Created by Roger on 2016/11/3.
 */
public class MergeSortTest {

    @Test
    public void test(){
        int[] a = {12, 35, 99, 18, 76};
        MergeSort.sortDownTop(a);

        System.out.println();
        System.out.println();
        System.out.println();

        MergeSort.sortTopDown(a, 0, a.length-1);
    }
}