package datastructures.queue;

import org.junit.Test;

/**
 * Created by Roger on 2016/10/27.
 */
public class CircularArrayQueueTest {

    @Test
    public void test() throws Exception {
        CircularArrayQueue<String> queue = new CircularArrayQueue<>(5);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");

        while (!queue.isEmpty()){
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();

        System.out.println(queue.size());
    }
}