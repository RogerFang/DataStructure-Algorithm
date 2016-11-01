package datastructures.queue;

import org.junit.Test;

/**
 * Created by Roger on 2016/10/26.
 */
public class SequenceArrayQueueTest {

    @Test
    public void test() throws Exception {
        SequenceArrayQueue<String> queue = new SequenceArrayQueue<>(5);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        // queue.enqueue("f");
        System.out.println(queue.size());

        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }

        queue.enqueue("f");
    }

}