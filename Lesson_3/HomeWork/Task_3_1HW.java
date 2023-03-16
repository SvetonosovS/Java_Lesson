package Lesson_3.HomeWork;

import java.util.*;;

public class Task_3_1HW {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите колличество чисел в списке: ");
        int quantityOfElements = in.nextInt();
        Random r = new Random();
        ArrayList<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < quantityOfElements; i++) {
            randomList.add(r.nextInt(-100, 101));
        }
        System.out.println("Общий список: " + randomList);
        randomList.removeIf(num -> (num % 2 == 0));
        System.out.println("Список без четных чисел: " + randomList);
    }
}
