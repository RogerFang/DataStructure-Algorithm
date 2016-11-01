package datastructures.list;

import org.junit.Test;

/**
 * Created by Roger on 2016/10/26.
 */
public class SingleLinkedListTest {

    @Test
    public void test() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        list.add(0, 1);
        list.add(0, 2);
        list.print();



        // list.remove(new Integer(2));
        // list.remove(new Integer(3));
        // list.print();
        // System.out.println(list.size());

        /*list.remove(0);
        list.print();
        list.remove(1);
        list.print();*/

        /*list.remove(2);
        list.print();

        System.out.println(list.get(1));

        System.out.println(list.contains(5));

        list.clear();
        list.print();*/
    }

    @Test
    public void test1(){
        Integer[] a = new Integer[10];
        System.out.println(a.length);
    }
}
