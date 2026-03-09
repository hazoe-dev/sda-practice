package dev.hazoe.dsa.collection;

import java.util.LinkedList;

public class LinkedListUsage {
    public static void main(String[] args) {
        //useAvailableObject();

        CustomLinkedList list = new CustomLinkedList();
        list.add(1);
        list.add(6);
        list.add(0);

        list.addFirst(5) ;
        list.printValues();
    }

    private static void useAvailableObject() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.addFirst(3);
        System.out.println(list);
        System.out.println(list.peek());// get HEAD
    }
}
