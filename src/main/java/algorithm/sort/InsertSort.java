package algorithm.sort;

/**
 * Created by Roger on 2016/11/3.
 * 插入排序：从大到小
 */
public class InsertSort extends Sort {

    public static void sort(int[] a){
        for (int i = 1; i < a.length; i++){
            for (int j = i; j > 0; j--){
                if (a[j] > a[j-1]){
                    swap(a, j, j-1);
                }
            }

            System.out.println("------第"+i+"趟-------");
            print(a);
        }
    }
}
