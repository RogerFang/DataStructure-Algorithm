package datastructures.stack;

import org.junit.Test;

/**
 * Created by Roger on 2016/10/26.
 */
public class ArrayStackTest {

    @Test
    public void test() throws Exception {
        ArrayStack stack = new ArrayStack(5);

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        // stack.push("f");
        System.out.println(stack.size());

        System.out.println(stack.pop());

        System.out.println(stack.peek());

    }
}
