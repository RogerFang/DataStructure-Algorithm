package datastructures.queue;

import org.junit.Test;

/**
 * Created by Roger on 2016/10/27.
 */
public class SingleLinkedListQueueTest {

    @Test
    public void test() throws Exception {
        SingleLinkedListQueue<String> queue = new SingleLinkedListQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");

        System.out.println(queue.size());

        while (!queue.isEmpty()){
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
    }

}