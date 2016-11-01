package datastructures.list;

/**
 * Created by Roger on 2016/10/25.
 * 线性表的链式存储结构：双链表
 */
public class DoubleLinkedList<T> {

    private Node head;
    private Node tail;
    // 节点个数
    private int theSize = 0;

    private static class Node<T>{
        private T value;
        private Node prev;
        private Node next;

        Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public DoubleLinkedList() {
    }

    /**
     * 添加一个元素到双链表
     * @param v
     */
    public void add(T v){
        Node<T> newNode = new Node<>(v, tail, null);
        if (tail == null){
            head = newNode;
        }else {
            tail.next = newNode;
        }
        tail = newNode;
        theSize++;
    }

    /**
     * 根据索引获取元素
     * @param i
     * @return
     */
    public T get(int i){
        return node(i).value;
    }

    /**
     * 删除索引的元素
     * Removes the element at the specified position in this list
     * @param i
     * @return
     */
    public T remove(int i){
        return unlink(node(i));
    }

    /**
     * 删除传入的对象
     * Removes the first occurrence of the specified element from this list
     * @param obj
     * @return
     */
    public boolean remove(Object obj){
        if (obj == null){
            for (Node<T> x = head; x != null; x = x.next){
                if (x.value == null){
                    unlink(x);
                    return true;
                }
            }
        }else {
            for (Node<T> x = head; x != null; x = x.next){
                if (obj.equals(x.value)){
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否包含传入的对象
     * @param obj
     * @return
     */
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    public int size(){
        return this.theSize;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public void clear(){
        for (Node<T> x = head; x != null;){
            Node<T> next = x.next;
            x.value = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head = tail = null;
        theSize = 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list
     * @param obj
     * @return
     */
    public int indexOf(Object obj){
        int index = 0;
        if (obj == null){
            for (Node<T> x = head; x != null; x = x.next){
                if (x.value != null){
                    return index;
                }
                index++;
            }
        }else {
            for (Node<T> x = head; x != null; x = x.next){
                if (obj.equals(x.value)){
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list
     * @param obj
     * @return
     */
    public int lastIndexOf(Object obj){
        int index = size();
        if (obj == null){
            for (Node<T> x = tail; x != null; x = x.prev){
                index--;
                if (x.value == null){
                    return index;
                }
            }
        }else {
            for (Node<T> x = tail; x != null; x = x.prev){
                index--;
                if (obj.equals(x.value)){
                    return index;
                }
            }
        }
        return -1;
    }

    public void print(){
        if (head == null || size() == 0){
            System.out.println("链表为空");
        }else {
            Node<T> current = head;
            while (current != null){
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    /**
     * Returns the (non-null) Node at the specified element index.
     */
    private Node<T> node(int index){
        checkIndex(index);

        Node<T> current;
        if (index < (size() >> 1)){
            current = head;
            for (int i = 0; i < index; i++){
                current = current.next;
            }
        }else {
            current = tail;
            for (int i = size() - 1; i > index; i--){
                current = current.prev;
            }
        }
        return current;
    }

    private T unlink(Node<T> p){
        T val = p.value;
        Node<T> prev = p.prev;
        Node<T> next = p.next;
        if (prev == null){
            head = next;
        }else {
            prev.next = next;
            p.prev = null;
        }

        if (next == null){
            tail = prev;
        }else {
            next.prev = prev;
            p.next = null;
        }

        p.value = null;
        theSize--;
        return val;
    }

    private void checkIndex(int index){
        if (index < 0 || index > size() - 1){
            throw new IndexOutOfBoundsException("传入索引无效:"+index);
        }
    }
}
