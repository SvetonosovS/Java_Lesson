package Lesson_3.HomeWork;

import java.util.*;

public class Task_3_3HW {
    public static void main(String[] args) {
        List<String> listStrings = List.of("1.1", "black", "Java", "77", "H2O", "-0.0001", "99.99", "1",
                "0");
                System.out.println("Исходный список " + listStrings);
        ArrayList<String> arrayListStrings = new ArrayList<>(listStrings);
        delIntFromList(arrayListStrings);
    }

    private static void delIntFromList(ArrayList<String> arrayListStrings) {
        for (int i = arrayListStrings.size() - 1; i >= 0; i--) {
            try {
                Integer.parseInt(arrayListStrings.get(i));
                arrayListStrings.remove(i);
            } catch (NumberFormatException ignored) {
            }
        }
        System.out.println("Обновленный список " + arrayListStrings);
    }
}