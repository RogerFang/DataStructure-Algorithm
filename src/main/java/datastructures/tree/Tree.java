package datastructures.tree;

/**
 * Created by Roger on 2016/10/27.
 * 树的实现：孩子兄弟表示法,
 * 如果想获取某节点的双亲节点，可以再添加一个双亲指针域
 */
public class Tree<T> {

    private static class TreeNode<T>{
        T element;
        // 孩子指针域：指向第一个儿子节点
        TreeNode<T> firstChild;
        // 兄弟指针域：指向兄弟节点
        TreeNode<T> nextSibling;
    }
}
