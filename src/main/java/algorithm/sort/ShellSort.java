package algorithm.sort;

/**
 * Created by Roger on 2016/11/3.
 * 希尔排序：从大到小
 * Hibbard增量：1,3,7,...,2^k-1
 */
public class ShellSort extends Sort{

    public static void sort(int[] a){
        int N = a.length;
        int maxK = (int)(Math.log(N + 1)/Math.log(2));
        for (int k = maxK; k >= 1; k--){
            int gap = (int) Math.pow(2, k) - 1;
            // 将数组变成gap有序
            for (int i = gap; i < N; i++){
                // 将a[i]插入到a[i-gap],a[i-2*gap],a[i-3*gap]...子数组之中
                for (int j = i; j >= gap; j-=gap){
                    if (a[j] > a[j - gap]){
                        swap(a, j, j-gap);
                    }
                }
            }
            System.out.println("------"+gap+"排序后-------");
            print(a);
        }
    }
}
