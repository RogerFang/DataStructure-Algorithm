package datastructures.tree;

import org.junit.Test;

/**
 * Created by Roger on 2016/10/29.
 */
public class RedBlackTreeTest {

    @Test
    public void test(){
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        /*tree.insert(4);
        tree.insert(2);
        tree.insert(5);
        tree.insert(1);
        tree.insert(3);*/
        tree.insert(4);
        tree.insert(3);
        tree.print();

        System.out.println();

        tree.insert(2);
        tree.print();
    }

    @Test
    public void t(){
        String s = "为了推进“标准联通一带一路湖北行动计划”，以第47届世界标准日系列活动为背景， 10月20日，由湖北省质量技术监督局主办，湖北省标准化与质量研究院、湖北广播电视台承办了“湖北标准走出去”专家访谈活动。省质监局党组副书记、副局长詹永杰...";
        System.out.println(s.length());
    }
}