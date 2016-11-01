package datastructures.queue;

/**
 * Created by Roger on 2016/10/27.
 * 循环队列：数组实现
 */
public class CircularArrayQueue<T> {

    private Object[] items;
    private int theSize;
    private int front;
    private int rear;

    public CircularArrayQueue(int maxSize) {
        this.items = new Object[maxSize];
        this.theSize = 0;
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 入队
     *
     * @param t
     */
    public void enqueue(T t) throws Exception {
        if (isFull()) {
            throw new Exception("循环队列已满，不能入队");
        }
        // 注意
        rear = (front + theSize) % items.length;
        items[rear] = t;
        theSize++;

    }

    /**
     * 出队
     *
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public T dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("循环队列为空队列，不能出队");
        }
        T ele = (T) items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        theSize--;
        return ele;
    }

    public int size() {
        return theSize;
    }

    /**
     * 判断已满，与顺序队列不同
     *
     * @return
     */
    public boolean isFull() {
        return items.length == theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

}
