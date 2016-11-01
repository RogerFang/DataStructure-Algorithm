package datastructures.tree;

/**
 * Created by Roger on 2016/10/29.
 * 红黑树
 */
public class RedBlackTree<T extends Comparable<? super T>> {

    private Node<T> root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private static class Node<T> {
        T element;        // 键
        Node<T> left;      // 左子树
        Node<T> right;     // 右子树
        boolean color;  // 由其父节点指向它的链接的颜色

        Node(T element, boolean color) {
            this.element = element;
            this.color = color;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(T ele){
        root = insert(ele, root);
        root.color = BLACK;
    }

    private Node<T> insert(T ele, Node<T> tree){
        if (tree == null){
            return new Node<>(ele, RED);
        }

        int cmpResult = ele.compareTo(tree.element);
        if (cmpResult < 0){
            tree.left = insert(ele, tree.left);
        }else if (cmpResult > 0){
            tree.right = insert(ele, tree.right);
        }else {
            // duplicate; do nothing
        }

        // check balance
        if (isRed(tree.right) && !isRed(tree.left)){
            // 情况一：红色右链接
            tree = rotateToLeft(tree);
        }
        if (isRed(tree.left) && isRed(tree.left.left)){ // 该步在下一步flipColors之前进行校验
            // 情况三：连续红色左节点, 进行一次右旋转变成情况二4-节点
            tree = rotateToRight(tree);
        }
        if (isRed(tree.left) && isRed(tree.right)){
            // 情况二：分解4-节点
            tree = filpColors(tree);
        }

        return tree;
    }

    /**
     * 左旋转：红色右链接 -> 红色左链接
     *
     * @param node
     * @return
     */
    private Node<T> rotateToLeft(Node<T> node) {
        Node<T> x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * 右旋转： 红色左链接 -> 红色右链接
     *
     * @param node
     * @return
     */
    private Node<T> rotateToRight(Node<T> node) {
        Node<T> x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * 转换一个节点的两个红色子节点的颜色从红变黑，同时把该节点的颜色设为红色
     * @param node
     */
    private Node<T> filpColors(Node<T> node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
        return node;
    }

    private  boolean isRed(Node<T> node){
        if (node == null) return false;
        return node.color == RED;
    }

    public void print(){
        if (root != null){
            print(root, root.element, 0);
        }
    }

    /**
     * @param node 打印的节点
     * @param ele ele 父节点的值
     * @param direction 0:根节点;-1:父节点的左儿子节点;1:父节点的右儿子节点
     */
    private void print(Node<T> node, T ele,  int direction){
        if (node != null){
            if (direction == 0){
                System.out.printf("%s是根节点，%s颜色\n", ele, node.color==RED?"红色":"黑色");
            }else {
                System.out.printf("%s是%s的%s儿子节点，%s颜色\n", node.element, ele, direction==-1?"left":"right", node.color==RED?"红色":"黑色");
            }
            print(node.left, node.element, -1);
            print(node.right, node.element, 1);
        }
    }
}
