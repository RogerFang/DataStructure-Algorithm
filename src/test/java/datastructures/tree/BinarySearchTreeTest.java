package datastructures.tree;

import org.junit.Test;

/**
 * Created by Roger on 2016/10/27.
 */
public class BinarySearchTreeTest {

    @Test
    public void test(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(6);
        // System.out.println(tree.contains(2));
        tree.print();

        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
    }
}