package datastructures.tree;

/**
 * Created by Roger on 2016/10/27.
 * 二叉查找树
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    private BinaryNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * 前序遍历
     * 1. 访问根节点
     * 2. 先序遍历左子树
     * 3. 先序遍历右子树
     */
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }

    private void preOrder(BinaryNode<T> node){
        if (node != null){
            System.out.print(node.element + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     * 1. 中序遍历左子树
     * 2. 访问根节点
     * 3. 中序遍历右子树
     */
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }

    private void inOrder(BinaryNode<T> node){
        if (node != null){
            inOrder(node.left);
            System.out.print(node.element + " ");
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历
     * 1. 后序遍历左子树
     * 2. 后序遍历右子树
     * 3. 访问根节点
     */
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }

    private void postOrder(BinaryNode<T> node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.element + " ");
        }
    }


    /**
     * 插入
     * @param ele
     */
    public void insert(T ele){
        root = insert(ele, root);
    }

    public void remove(T ele){
        root = remove(ele, root);
    }

    /**
     * 是否包含某元素
     *
     * @param ele
     * @return
     */
    public boolean contains(T ele) {
        return contains(ele, root);
    }

    /**
     * 清空树
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * 判断空
     *
     * @return
     */
    public boolean isEmpty() {
        return root == null;
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
    private void print(BinaryNode<T> node, T ele, int direction){
        if (node != null){
            if (direction == 0){
                System.out.printf("%s是根节点\n", ele);
            }else {
                System.out.printf("%s是%s的%s儿子节点\n", node.element, ele, direction==-1?"left":"right");
            }
            print(node.left, node.element, -1);
            print(node.right, node.element, 1);
        }
    }

    /**
     * @param ele
     * @param node
     * @return 返回子树node的新的根节点
     */
    private BinaryNode<T> insert(T ele, BinaryNode<T> node) {
        if (node == null) {
            return new BinaryNode<T>(ele);
        }

        int cmpResult = ele.compareTo(node.element);

        if (cmpResult < 0) {
            node.left = insert(ele, node.left);
        } else if (cmpResult > 0) {
            node.right = insert(ele, node.right);
        } else {
            // 插入的元素重复
            System.out.println("INFO: duplicated element");
        }

        return node;
    }

    /**
     * 删除节点时, 需要考虑该节点是有一个还是两个子树
     *
     * @param ele
     * @param node
     * @return 返回子树node的新的根节点
     */
    private BinaryNode<T> remove(T ele, BinaryNode<T> node) {
        if (node == null) {
            // Element not found, do nothing
            return null;
        }

        int cmpResult = ele.compareTo(node.element);

        if (cmpResult < 0) {
            node.left = remove(ele, node.left);
        } else if (cmpResult > 0) {
            node.right = remove(ele, node.right);
        } else if (node.left != null && node.right != null) {
            // 该节点有两个子树, 取右子树的最小元填充此节点
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else {
            // 该节点只有一个子树, 直接调整子树到填补该节点位置
            node = (node.left != null) ? node.left : node.right;
        }

        return node;
    }

    private boolean contains(T ele, BinaryNode<T> node) {
        if (node == null) {
            return false;
        }

        int cmpResult = ele.compareTo(node.element);

        if (cmpResult < 0) {
            return contains(ele, node.left);
        } else if (cmpResult > 0) {
            return contains(ele, node.right);
        } else {
            return true;
        }
    }

    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    private static class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T element) {
            this(element, null, null);
        }

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
