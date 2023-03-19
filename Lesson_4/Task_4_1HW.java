package Lesson_4;

import java.util.ArrayList;
import java.util.*;

public class Task_4_1HW {
    public static void main(String[] args) {   
        actionsWithString();
    }

    private static void actionsWithString() {
        Scanner in = new Scanner(System.in);
        System.out.println("нажмите 'print' чтобы показать все записи");
        System.out.println("нажмите 'revert' чтобы удалить последнюю запись");
        System.out.println("нажмите 'stop' чтобы выйти из программы"); 
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            System.out.print("Введите строку: ");
            String input = in.nextLine();
            if (input.equals("print")) {
                System.out.println("Введенные строки: ");
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.println(list.get(i));
                }
            } else if (input.equals("revert")) {
                if (list.size() > 0) {
                    list.remove(list.size() - 1);
                    System.out.println("Предыдущая введенная строка удалена.");
                } else {
                    System.out.println("Нет записей.");
                }
            } else if (input.equals("stop")) {
                break;
            } else {
                list.add(input);
            }
        } in.close();
    }
}