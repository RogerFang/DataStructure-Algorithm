package datastructures.tree;

/**
 * Created by Roger on 2016/10/28.
 */
public class SplayTree<T extends Comparable<? super T>> {

    private SplayNode<T> root;

    private static class SplayNode<T>{
        private T element;
        SplayNode<T> left;
        SplayNode<T> right;

        public SplayNode() {
            this.left = null;
            this.right = null;
        }

        public SplayNode(T element) {
            this(element, null, null);
        }

        public SplayNode(T element, SplayNode<T> left, SplayNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 插入
     * @param ele
     */
    public void insert(T ele){
        root = insert(ele, root);
        root = splay(ele);
    }

    /**
     * @param ele
     * @param node
     * @return 返回子树node的新的根节点
     */
    private SplayNode<T> insert(T ele, SplayNode<T> node) {
        if (node == null) {
            return new SplayNode<T>(ele);
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
     * 删除元素
     * @param ele
     */
    public void remove(T ele){
        root = remove(ele, root);
    }

    /**
     * 1、首先对ele进行一次伸展
     * 2、然后判断移动到根节点的元素是不是ele
     *    2.1、如果相等, 则找到该元素ele的前驱节点作为新的根节点
     *    2.2、如果不等, 则不做处理, 因为一开始的伸展操作就已经将ele的前驱节点移动到根节点了
     * @param ele
     * @return
     */
    private SplayNode<T> remove(T ele, SplayNode<T> tree){
        if (tree == null){
            return null;
        }

        tree = topDownSplay(ele, tree);

        if (tree.element.compareTo(ele) == 0){
            // 找到该元素, 对树进行调整并删除该元素
            SplayNode<T> x;
            if (tree.left != null){
                // 删除该元素后, 需要重新伸展树得到一个根节点
                // 从左子树中找到最大的节点(删除元素的前驱节点)作为新的根节点
                tree.left = topDownSplay(ele, tree.left);
                // 此时左子树不存在右儿子, 将原树的右子树直接赋给伸展后的左子树的右儿子
                tree.left.right = tree.right;
                tree = tree.left;
            }else {
                tree = tree.right;
            }
        }

        return tree;
    }

    /**
     * 伸展
     * @param ele
     * @return
     */
    public SplayNode<T> splay(T ele){
        return topDownSplay(ele, root);
    }

    /**
     * 自顶向下伸展
     * 构建两棵临时的树──左树和右树。没有被移走的节点构成的树称作中树。
     * 1、目标节点和root相连时：一次link操作完成伸展
     * 2、目标节点有父节点和祖先节点, 并且呈之字形：通过两次link操作完成伸展
     * 3、目标节点有父节点和祖先节点, 并且呈一字形：先通过一次旋转, 再通过一次link操作完成伸展 (这里不是很懂，如果也通过两次link操作也能达到把目标节点移动到root的目的啊????)
     * 注意此处的节点N, 最后所有的左树集中在N的右子树上, 而所有的右树集中在N的左子树上。
     * 因为每次left link需要将中树上的部分节点移到左树的最右端(也就是最大的位置上), 这里的节点l的作用可以看做是为了方便在左树的最右端继续添加从中树移过来的节点;
     * 同理, right link时, 节点r和节点l的作用类似。
     * @param ele
     * @param tree
     * @return
     */
    private SplayNode<T> topDownSplay(T ele, SplayNode<T> tree){
        if (tree == null){
            return null;
        }

        SplayNode<T> N = new SplayNode<T>();
        SplayNode<T> l = N;
        SplayNode<T> r = N;
        SplayNode<T> c;

        for (;;){
            int cmpResult = ele.compareTo(tree.element);
            if (cmpResult < 0){
                if (tree.left == null){
                    break;
                }

                /* rotate right*/
                if (ele.compareTo(tree.left.element) < 0){
                    c = tree.left;
                    tree.left = c.right;
                    c.right = tree;
                    tree = c;
                    if (tree.left == null){
                        break;
                    }
                }

                /* link right */
                r.left = tree;
                r = tree;
                tree = tree.left;
            }else if (cmpResult > 0){
                if (tree.right == null){
                    break;
                }

                /* rotate left */
                if (ele.compareTo(tree.right.element) > 0){
                    c = tree.right;
                    tree.right = c.left;
                    c.left = tree;
                    tree = c;
                    if (tree.right == null){
                        break;
                    }
                }

                /* link left */
                l.right = tree;
                l = tree;
                tree = tree.right;
            }else {
                break;
            }
        }

        /* assemble */
        l.right = tree.left;
        r.left = tree.right;
        tree.left = N.right;
        tree.right = N.left;

        return tree;
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
    private void print(SplayNode<T> node, T ele, int direction){
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
