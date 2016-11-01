package datastructures.heap;

import org.junit.Test;

/**
 * Created by Roger on 2016/11/1.
 */
public class BinaryHeapTest {

    @Test
    public void test() throws Exception {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.insert(100);
        heap.insert(20);
        heap.insert(30);
        heap.insert(60);
        heap.insert(80);
        heap.insert(40);
        heap.print();

        System.out.println();

        heap.deleteMin();

        heap.print();
    }

}