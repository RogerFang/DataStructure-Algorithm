package algorithm.sort;

/**
 * Created by Roger on 2016/11/3.
 * 归并排序：从大到小
 */
public class MergeSort extends Sort {

    private static int[] tmpArray = new int[100];

    /**
     * 自上而下：利用递归实现的分治思想
     *
     * @param a
     */
    public static void sortTopDown(int[] a, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sortTopDown(a, low, mid);
        sortTopDown(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    /**
     * 自下而上
     * 先归并那些微型数组, 然后再成对归并得到的子数组。
     * 1、首先进行两两归并(把每个元素想象成一个大小为1的数组)
     * 2、然后四四归并(将两个大小为2的数组归并成一个有4个元素的数组)
     * 3、然后是八八归并....一直下去
     *
     * @param a
     */
    public static void sortDownTop(int[] a) {
        for (int sz = 1; sz < a.length; sz *= 2) {
            System.out.println("-------每组" + sz + "个元素------");
            for (int i = 0; i < a.length - sz; i += sz * 2) {
                merge(a, i, i + sz - 1, Math.min(i + sz * 2 - 1, a.length - 1));
            }
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            tmpArray[i] = a[i];
        }
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = tmpArray[j++];
            else if (j > high) a[k] = tmpArray[i++];
            else if (tmpArray[i] < tmpArray[j]) a[k] = tmpArray[j++];
            else a[k] = tmpArray[i++];
        }
        print(a);
    }
}
