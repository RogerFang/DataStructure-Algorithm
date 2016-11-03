package algorithm.sort;

/**
 * Created by Roger on 2016/11/3.
 * 冒泡排序：从大到小
 */
public class BubbleSort extends Sort{

    public static void sort(int[] a){
        // n个数排序, 只需要n-1趟
        for (int i = 0; i < a.length - 1; i++){
            System.out.println("------第"+(i+1)+"趟-------");
            for (int j = 0; j < a.length - 1 - i; j++){
                if (a[j] < a[j+1]){
                    swap(a, j, j+1);
                }
                print(a);
            }
        }
    }
}
