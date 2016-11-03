package algorithm.sort;

/**
 * Created by Roger on 2016/11/3.
 * 选择排序：从大到小
 */
public class SelectSort extends Sort {

    public static void sort(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            int max = i;
            for (int j = i+1; j < a.length; j++){
                if (a[j] > a[max]){
                    max = j;
                }
            }
            swap(a, i, max);

            System.out.println("------第"+(i+1)+"趟-------");
            print(a);
        }
    }
}
