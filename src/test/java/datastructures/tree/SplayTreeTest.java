package datastructures.tree;

import org.junit.Test;

/**
 * Created by Roger on 2016/10/28.
 */
public class SplayTreeTest {

    @Test
    public void test(){
        SplayTree<Integer> tree = new SplayTree<>();
        tree.insert(10);
        tree.insert(50);
        tree.insert(40);
        tree.insert(60);
        tree.insert(30);
        tree.insert(20);

        tree.print();

        tree.remove(30);
        tree.print();
    }

}