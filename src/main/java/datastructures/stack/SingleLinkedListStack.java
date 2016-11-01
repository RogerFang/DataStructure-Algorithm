package datastructures.stack;

import datastructures.list.SingleLinkedList;

/**
 * Created by Roger on 2016/10/26.
 * 栈: 单链表实现
 */
public class SingleLinkedListStack<T> {

    private SingleLinkedList<T> elementList;

    public SingleLinkedListStack() {
        this.elementList = new SingleLinkedList<>();
    }

    /**
     * 入栈
     * @param v
     */
    public void push(T v){
        elementList.add(0, v);
    }

    /**
     * 出栈: 单链表的实现，栈顶始终位于索引为0的结点
     * @return
     * @throws Exception
     */
    public T pop() throws Exception {
        if (elementList.isEmpty()){
            throw new Exception("栈为空");
        }
        return elementList.remove(0);
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public T peek(){
        return elementList.get(0);
    }

    /**
     * 判断栈空
     * @return
     */
    public boolean isEmpty(){
        return elementList.size() == 0;
    }

    public int size(){
        return elementList.size();
    }
}
