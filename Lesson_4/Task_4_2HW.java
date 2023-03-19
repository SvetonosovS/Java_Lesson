package Lesson_4;

import java.util.*;

public class Task_4_2HW {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
            list.add("black");
            list.add("red");
            list.add("green");
            list.add("blue");
            System.out.println(list);
            System.out.println(reverseLinkedList(list));
        }

    public static LinkedList reverseLinkedList(LinkedList list) {
        LinkedList reversedList = new LinkedList();
        for(int i=list.size()-1; i>=0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }
}