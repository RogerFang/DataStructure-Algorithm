package datastructures.tree;

/**
 * Created by Roger on 2016/10/28.
 * AVL树
 */
public class AvlTree<T extends Comparable<? super T>> {

    private AvlNode<T> root;

    private static class AvlNode<T> {
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        public AvlNode(T element) {
            this(element, null, null);
        }

        public AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 1;
        }
    }

    /**
     * 插入元素到Avl树
     * @param ele
     */
    public void insert(T ele){
        root = insert(ele, root);
    }

    /**
     * 插入元素到子树中
     * @param ele
     * @param subroot 子树根节点
     * @return 新的子树根节点
     */
    private AvlNode<T> insert(T ele, AvlNode<T> subroot){
        if (subroot == null){
            return new AvlNode<T>(ele);
        }

        int cmpResult = ele.compareTo(subroot.element);

        if (cmpResult < 0){
            subroot.left = insert(ele, subroot.left);
            // 往左插入元素时, 破坏平衡条件
            if (height(subroot.left) - height(subroot.right) == 2){
                // 判断是左左还是左右情况
                if (subroot.left.element.compareTo(ele) > 0){
                    subroot = rotateWithLeftChild(subroot);
                }else {
                    subroot = doubleRotateWithLeftChild(subroot);
                }
            }
        }else if (cmpResult > 0){
            subroot.right = insert(ele, subroot.right);
            // 往右插入元素时, 破坏平衡条件
            if (height(subroot.right) - height(subroot.left) == 2){
                // 判断是右右还是右左情况
                if (subroot.right.element.compareTo(ele) < 0){
                    subroot = rotateWithRightChild(subroot);
                }else {
                    subroot = doubleRotateWithRightChild(subroot);
                }
            }
        }else {
            // Duplicate; do nothing
        }

        // 更新subroot的height
        subroot.height = Math.max(height(subroot.left), height(subroot.right)) + 1;
        return subroot;
    }

    /**
     * 从Avl树种删除元素
     * @param ele
     */
    public void remove(T ele){
        root = remove(ele, root);
    }

    /**
     * 从Avl子树中删除元素
     * @param ele
     * @param subroot 子树根节点
     * @return 新的子树根节点
     */
    private AvlNode<T> remove(T ele, AvlNode<T> subroot){
        if (subroot == null){
            return null;
        }

        int cmpResult = ele.compareTo(subroot.element);
        if (cmpResult < 0){
            subroot.left = remove(ele, subroot.left);
            if (height(subroot.right) - height(subroot.left) == 2){
                // 删除左子树的节点失去平衡
                if (height(subroot.right.left) > height(subroot.right.right)){
                    subroot = doubleRotateWithRightChild(subroot);
                }else {
                    subroot = rotateWithRightChild(subroot);
                }
            }
        }else if (cmpResult > 0){
            subroot.right = remove(ele, subroot.right);
            if (height(subroot.left) - height(subroot.right) == 2){
                // 删除右子树的节点失去平衡
                if (height(subroot.left.right) > height(subroot.left.left)){
                    subroot = doubleRotateWithLeftChild(subroot);
                }else {
                    subroot = rotateWithLeftChild(subroot);
                }
            }
        }else {
            // 对应删除的节点
            if (subroot.left != null && subroot.right != null){
                // 左右子树都非空
                if (height(subroot.left) > height(subroot.right)){
                    // 如果左子树比右子树高
                    // 1、找出tree的左子树的最大节点
                    // 2、将该最大节点赋给tree
                    // 3、从tree的左子树删除该最大节点
                    // 这种方式的好处：删除tree的左子树最大节点后, AVL树仍然是平衡的
                    AvlNode<T> leftMax = maximum(subroot.left);
                    subroot.element = leftMax.element;
                    subroot.left = remove(leftMax.element, subroot.left);
                }else {
                    // 如果右子树比左子树高或相等
                    // 1、找出tree的右子树的最小节点
                    // 2、将该最小节点赋给tree
                    // 3、从tree的右子树删除该最小节点
                    // 这种方式的好处：删除tree的右子树最小节点后, AVL树仍然是平衡的
                    AvlNode<T> rightMin = minimum(subroot.right);
                    subroot.element = rightMin.element;
                    subroot.right = remove(rightMin.element, subroot.right);
                }
            }else {
                subroot = (subroot.left != null) ? subroot.left : subroot.right;
            }
        }
        return subroot;
    }

    /**
     * 左左 单旋转
     * @param k2 平衡条件破坏的子树的根节点
     * @return 返回新的根节点
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        return k1;
    }

    /**
     * 右右 单旋转
     * @param k2 平衡条件破坏的子树的根节点
     * @return 返回新的根节点
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        return k1;
    }


    /**
     * 左右 双旋转
     * 先进行一次右旋转, 在进行一次左旋转
     * @param k3 平衡条件破坏的子树的根节点
     * @return 返回新的根节点
     */
    private AvlNode<T> doubleRotateWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * 右左 双旋转
     * 先进行一次左旋转, 在进行一次右旋转
     * @param k3 平衡条件破坏的子树的根节点
     * @return 返回新的根节点
     */
    private AvlNode<T> doubleRotateWithRightChild(AvlNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    private int height(AvlNode<T> node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 查找该子树的最大节点
     * @param subroot
     * @return
     */
    private AvlNode<T> maximum(AvlNode<T> subroot){
        if (subroot == null){
            return null;
        }

        while (subroot.right != null){
            subroot = subroot.right;
        }
        return subroot;
    }

    /**
     * 查找该子树的最小节点
     * @param subroot
     * @return
     */
    public AvlNode<T> minimum(AvlNode<T> subroot){
        if (subroot == null){
            return null;
        }

        while (subroot.left != null){
            subroot = subroot.left;
        }
        return subroot;
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
    private void print(AvlNode<T> node, T ele, int direction){
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
}
