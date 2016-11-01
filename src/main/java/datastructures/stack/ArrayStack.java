package datastructures.stack;

/**
 * Created by Roger on 2016/10/26.
 * 栈: 数组实现
 */
public class ArrayStack<T> {
    private Object[] elementData;

    // 栈顶位置
    int top;

    public ArrayStack(int maxSize) {
        this.elementData = new Object[maxSize];
        this.top = -1;
    }

    /**
     * 获取栈中元素的个数
     * Returns the number of elements in this stack.
     * @return
     */
    public int size(){
        return top + 1;
    }

    /**
     * 判断栈空
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 判断栈满
     * @return
     */
    public boolean isFull(){
        return top == elementData.length - 1;
    }

    /**
     * 入栈: 依次加入数据
     * @param data
     * @return
     */
    public boolean push(Object data) throws Exception {
        if (isFull()){
            throw new Exception("栈满");
        }

        this.elementData[++top] = data;
        return true;
    }

    /**
     * 出栈: 从栈顶取出元素
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public T pop() throws Exception {
        if (isEmpty()){
            throw new Exception("栈空");
        }

        return (T) this.elementData[top--];
    }

    /**
     * 返回栈顶元素
     * @return
     */
    @SuppressWarnings("unchecked")
    public T peek(){
        return (T) this.elementData[top];
    }
}
