package datastructures.list;

/**
 * Created by Roger on 2016/10/25.
 * 线性表的链式存储结构：单链表
 */
public class SingleLinkedList<T> {
    // 首元素
    private Node<T> head;
    // 尾元素
    private Node<T> last;

    // 元素个数
    private int theSize = 0;

    private static class Node<T>{
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public SingleLinkedList() {
    }

    /**
     * 增加一个数据到list
     * @param v
     */
    public void add(T v){
        Node<T> newNode = new Node<>(v, null);
        if (isEmpty()){
            head = newNode;
            last = head;
        }else {
            last.next = newNode;
            last = newNode;
        }
        theSize++;
    }

    /**
     * 在index处添加元素v，其他元素后移
     * @param index
     * @param v
     */
    public void add(int index, T v){
        if (index == 0){
            Node<T> newNode = new Node<>(v, head);
            head = newNode;
        }else {
            checkIndex(index);
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++){
                current = current.next;
            }
            Node<T> newNode = new Node<>(v, current.next);
            current.next = newNode;
        }
        theSize++;
    }

    /**
     * 根据索引获取值
     * @param index
     * @return
     */
    public T get(int index){
        return node(index).value;
    }

    /**
     * 是否包含传入的对象
     * @param obj
     * @return
     */
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    /**
     * 删除list中首次出现的value
     * @param v
     * @return
     */
    public boolean remove(Object obj){
        Node<T> current = head;
        Node<T> prev = current;
        for (int i = 0; i < size(); i++){
            if (current.value.equals(obj)){
                if (i == 0){
                    head = current.next;
                    theSize--;
                    return true;
                }

                prev.next = current.next;
                theSize--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    /**
     * 根据索引值删除元素
     * @param index
     * @return
     */
    public T remove(int index){
        checkIndex(index);
        theSize--;
        if (index == 0){
            Node<T> current = head;
            T val = current.value;
            head = current.next;
            current.value = null;
            current.next = null;
            return val;
        }else {
            Node<T> prev = node(index-1);
            Node<T> current = prev.next;
            T val = current.value;
            prev.next = current.next;
            current.value = null;
            current.next = null;
            return val;
        }
    }

    /**
     * 清空链表
     */
    public void clear(){
        head = null;
        theSize = 0;
    }

    /**
     * 打印全部链表
     */
    public void print(){
        if (head == null || size() == 0){
            System.out.println("链表为空");
        }else {
            Node<T> current = head;
            while (current != null){
                System.out.print(current.value + " ");
                current = current.next;
            }
        }
        System.out.println();
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

    public int size(){
        return this.theSize;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    /**
     * Returns the (non-null) Node at the specified element index.
     */
    private Node<T> node(int index){
        checkIndex(index);

        Node<T> current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }

        return current;
    }

    private void checkIndex(int index){
        if (index < 0 || index > size() - 1){
            throw new IndexOutOfBoundsException("传入索引无效:"+index);
        }
    }
}
