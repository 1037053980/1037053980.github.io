package cn.tedu.store.study.demo3;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        /*List是一个列表,它是一个接口
        *它有2个实现类:
        *ArrayList:是线性表的顺序存储实现（用数组实现）
        * LinkedList:是线性表的链式存储实现。
        */
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        for (String s:
             list) {
            System.out.println(s);
        }
    }
}
