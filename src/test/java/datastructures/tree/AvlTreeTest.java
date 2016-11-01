package datastructures.tree;

import org.junit.Test;

/**
 * Created by Roger on 2016/10/28.
 */
public class AvlTreeTest {

    @Test
    public void test(){
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(16);
        tree.print();

        tree.remove(4);
        tree.print();
    }
}