package datastructures.queue;

import datastructures.list.SingleLinkedList;

/**
 * Created by Roger on 2016/10/27.
 * 队列：单链表实现
 */
public class SingleLinkedListQueue<T> {
    private SingleLinkedList<T> list;

    public SingleLinkedListQueue() {
        list = new SingleLinkedList<>();
    }

    /**
     * 入队，链表增加一个元素
     * @param t
     */
    public void enqueue(T t){
        list.add(t);
    }

    /**
     * 出队，链表删除索引为0的元素
     * @return
     */
    public T dequeue() throws Exception {
        if (isEmpty()){
            throw new Exception("队列是空的");
        }
        return list.remove(0);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }
}
