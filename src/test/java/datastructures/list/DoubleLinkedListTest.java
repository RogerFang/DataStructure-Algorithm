package datastructures.list;

import org.junit.Test;

/**
 * Created by Roger on 2016/10/26.
 */
public class DoubleLinkedListTest {

    @Test
    public void test(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2);
        list.print();

        System.out.println(list.get(3));

        System.out.println(list.indexOf(4));

        System.out.println(list.contains(2));

        System.out.println(list.lastIndexOf(2));

        System.out.println("remove index: val=" + list.remove(3));
        list.print();
        System.out.println("remove object: " + list.remove(new Integer(2)));
        list.print();

        list.clear();
        list.print();
    }
}
