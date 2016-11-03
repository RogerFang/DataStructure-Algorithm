package algorithm.sort;

/**
 * Created by Roger on 2016/11/3.
 */
public class Sort {

    public static void print(int[] a){
        for (int i: a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
