package Lesson_1.HomeWork;

import java.util.Scanner;
import java.time.*;

public class Task_3 {
    public static void main(String[] args) {
        greetingByTime ();
    }
    
    private static void greetingByTime() {
        String nameUser = getNameUser();
        int hour = getCurrentTime();
        if (5 <= hour && hour <= 11) {
            System.out.printf("Доброе утро, %s!", nameUser);
        } else if (12 <= hour && hour <= 17) {
            System.out.printf("Добрый день, %s!", nameUser);
        } else if (18 <= hour && hour <= 22) {
            System.out.printf("Добрый вечер, %s!", nameUser);
        } else {
            System.out.printf("Доброй ночи, %s!", nameUser);
        }
    }

    private static String getNameUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String nameUser = in.nextLine();
        in.close();
        return nameUser;
    }

    private static int getCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        int hour = currentTime.getHour();
        return hour;
    }
}