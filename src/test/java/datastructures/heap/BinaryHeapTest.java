package datastructures.heap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roger on 2016/11/1.
 */
public class BinaryHeapTest {

    @Test
    public void test() throws Exception {
        /*BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.insert(100);
        heap.insert(20);
        heap.insert(30);
        heap.insert(60);
        heap.insert(80);
        heap.insert(40);
        heap.print();

        System.out.println();

        heap.deleteMin();

        heap.print();*/

        List<Integer> data = new ArrayList<>();
        data.add(100);
        data.add(20);
        data.add(30);
        data.add(60);
        data.add(80);
        data.add(40);
        BinaryHeap<Integer> heap = new BinaryHeap<>(data);
        heap.print();
    }

}