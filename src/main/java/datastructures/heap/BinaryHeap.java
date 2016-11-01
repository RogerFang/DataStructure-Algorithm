package datastructures.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roger on 2016/11/1.
 * 二叉堆：最小堆
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private List<T> heap;

    public BinaryHeap() {
        this.heap = new ArrayList<>();
    }

    /**
     * 插入
     *
     * @param ele
     */
    public void insert(T ele) {
        heap.add(ele);
        percolateUp(heap.size() - 1);
    }

    /**
     * 删除最小元
     * @return
     */
    public T deleteMin() throws Exception {
        if (isEmpty()){
            throw new Exception("堆为空");
        }

        T ele = heap.get(0);
        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);
        if (size() > 1){
            percolateDown(0);
        }
        return ele;
    }

    /**
     * 上滤
     */
    private void percolateUp(int index) {
        int parentIndex = (index - 1) / 2;
        T tmpEle = heap.get(index);

        while (index > 0) {
            if (tmpEle.compareTo(heap.get(parentIndex)) >= 0) {
                break;
            }else {
                heap.set(index, heap.get(parentIndex));
                index = parentIndex;
                parentIndex = (index - 1)/2;
            }
        }
        heap.set(index, tmpEle);
    }

    /**
     * 下滤
     */
    private void percolateDown(int index) {
        // 先设置为左儿子索引
        int childIndex = 2 * index + 1;
        T tmpEle = heap.get(index);

        while (childIndex < size()){
            // 左右儿子大小比较, 选择较小者
            if (childIndex < size() - 1){
                int cmp = heap.get(childIndex).compareTo(heap.get(childIndex + 1));
                if (cmp > 0){
                    // 右儿子较小
                    childIndex++;
                }
            }

            int cmp = tmpEle.compareTo(heap.get(childIndex));
            if (cmp <= 0){
                break;
            }else {
                heap.set(index, heap.get(childIndex));
                index = childIndex;
                childIndex = 2 * index + 1;
            }
        }
        heap.set(index, tmpEle);
    }

    public boolean isEmpty(){
        return heap.size() == 0;
    }

    public int size(){
        return heap.size();
    }

    public void print(){
        for (int i = 0; i < size(); i++){
            System.out.print(heap.get(i) + " index=" + i);
            if (i > 0){
                System.out.print(", 是" + heap.get((i-1)/2) + "的儿子");
            }else {
                System.out.print(", 是根");
            }
            System.out.println();
        }
    }
}
