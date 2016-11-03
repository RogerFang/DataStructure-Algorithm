package algorithm.sort;

/**
 * Created by Roger on 2016/11/3.
 * 堆排序：从大到小(最小堆)
 */
public class HeapSort extends Sort {

    public static void sort(int[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            percolateDown(a, i, a.length);
        }

        for (int i = a.length - 1; i >= 0; i--) {
            // deleteMin 放到数组最后
            swap(a, 0, i);
            percolateDown(a, 0, i);
            System.out.println("--------第"+(a.length - i)+"趟---------");
            print(a);
        }
    }

    /**
     * 用于buildHeap和deleteMin
     *
     * @param a
     * @param index 开始下滤的索引
     * @param n     堆的逻辑大小
     */
    private static void percolateDown(int[] a, int index, int n) {
        int child;
        int tmp;
        for (tmp = a[index]; leftChild(index) < n; index = child) {
            child = leftChild(index);
            if (child != n - 1 && a[child] > a[child + 1]) {
                // 右儿子
                child++;
            }
            if (tmp > a[child]) {
                a[index] = a[child];
            } else {
                break;
            }
        }
        a[index] = tmp;
    }

    private static int leftChild(int i) {
        return 2 * i + 1;
    }
}
