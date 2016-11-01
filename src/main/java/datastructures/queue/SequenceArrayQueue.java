package datastructures.queue;

/**
 * Created by Roger on 2016/10/26.
 * 顺序队列：数组实现
 */
public class SequenceArrayQueue<T> {

    private Object[] items;
    private int theSize;
    private int front;
    private int rear;

    public SequenceArrayQueue(int maxSize) {
        this.items = new Object[maxSize];
        this.theSize = 0;
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 入队
     * @param t
     */
    public void enqueue(T t) throws Exception {
        if (isFull()){
            throw new Exception("顺序队列已满，不能入队");
        }
        items[rear++] = t;
        theSize++;

    }

    /**
     * 出队
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public T dequeue() throws Exception {
        if (isEmpty()){
            throw new Exception("顺序队列为空队列，不能出队");
        }
        T ele = (T) items[front];
        items[front] = null;
        front++;
        theSize--;
        return ele;
    }

    public int size(){
        return theSize;
    }

    public boolean isFull(){
        return items.length == rear;
    }

    public boolean isEmpty(){
        return theSize == 0;
    }

    /**
     * 扩容2倍
     */
    /*public void resize(){
        int newCapacity = items.length << 1;
        Arrays.copyOf(items, newCapacity);
    }*/
}
