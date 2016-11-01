package datastructures.stack;

import org.junit.Test;

/**
 * Created by Roger on 2016/10/26.
 */
public class SingleLinkedListStackTest {

    @Test
    public void test() throws Exception {
        SingleLinkedListStack<String> stack = new SingleLinkedListStack<>();

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        System.out.println(stack.size());

        System.out.println(stack.pop());

        System.out.println(stack.peek());
    }
}