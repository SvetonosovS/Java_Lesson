package Lesson_6;

import java.util.*;

public class Task_6_1HW {
    public static void main(String[] args) {
    Laptop l1 = new Laptop ("HP", "Omen",
                17.3, 1024, "Grey");
    Laptop l2 = new Laptop ("Lenovo", "ideapad",
                17.3, 1024, "Black");
    Laptop l3 = new Laptop ("Apple", "MacBook Air",
                13.0, 512, "Black");
    Laptop l4 = new Laptop ("Apple", "MacBook Air",
                15.6, 215, "Grey");
    Laptop l5 = new Laptop ("Asus", "Vivobook Flip",
                15.0, 125, "White");
    Laptop l6 = new Laptop("MSI", "Raider", 17.3, null, "White");


        ArrayList<Laptop> listLaptops = new ArrayList<>();
        Collections.addAll(listLaptops, l1, l2, l3, l4, l5, l6);
//        System.out.println(listLaptops);
        startFilterLaptops(listLaptops);

    }

    private static void startFilterLaptops(ArrayList<Laptop> listLaptops) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.printf("%nВыберите : %n" +
                    " 1. Показать список ноутбуков%n" +
                    " 2. Выбрать по диагонали экрана%n" +
                    " 3. Выбрать по объему жесткого диска%n" +
                    " 4. Выбрать по цвету%n" +
                    " 5. Выбрать производителя%n" +
                    " 0. Выход из программы %n");
                    
            String inputString = in.nextLine();

            if (inputString.isBlank()) {
                System.out.println("Ошибка ввода. Повторите\n");
                continue;
            }

            if (inputString.equalsIgnoreCase("0")) {
                System.out.println("Приложение не активно.\n");
                break;
            }

            if (inputString.equalsIgnoreCase("1")) {
                printAll(listLaptops);
                continue;
            }

            if (inputString.equalsIgnoreCase("2")) {
                filterScreenDiagonal(listLaptops);
                continue;
            }

            if (inputString.equalsIgnoreCase("3")) {
                filterVolumeSSD(listLaptops);
                continue;
            }
 
             if (inputString.equalsIgnoreCase("4")) {
                filterByColor(listLaptops);
                continue;
            }

            if (inputString.equalsIgnoreCase("5")) {
                filterManufacturer(listLaptops);

            } else {
                System.out.println("Некорректный ввод. Повторите\n");
            }
        } in.close();
    }



    private static void filterManufacturer(ArrayList<Laptop> listLaptops) {
        String msg = "Введите производителя:\n";
        String dateFromUser = getDateFromUser(msg);
        int count = 0;
        for (Laptop item : listLaptops) {
            if (item.getManufacturer().equals(dateFromUser)) {
                item.printLaptop();
                count++;
            }
        }
        if (count == 0) {
            System.out.printf("Такого производителя нет в наличии.%n");
        }
    }

    private static void filterVolumeSSD(ArrayList<Laptop> listLaptops) {
        String msg = "Введите минимальный объем памяти жесткого диска:\n";
        String dateFromUser = getDateFromUser(msg);
        try {
            int volumeSSDFromUser = Integer.parseInt(dateFromUser);
            int count = 0;
            for (Laptop item : listLaptops) {
                if (item.getVolumeSSD() >= volumeSSDFromUser) {
                    item.printLaptop();
                    count++;
                }
            }
            if (count == 0) {
                System.out.printf("Нет в наличии.%n");
            }
        } catch (NumberFormatException e) {
            System.out.printf("Введены некорректные данные.%n");
        }
    }

    private static void filterScreenDiagonal(ArrayList<Laptop> listLaptops) {
        String msg1 = "Укажите диагональ экрана (min):\n";
        String minDiag = getDateFromUser(msg1);
        String msg2 = "Укажите диагональ экрана (max):\n";
        String maxDiag = getDateFromUser(msg2);
        try {
            double minDiagFromUser = Double.parseDouble(minDiag);
            double maxDiagFromUser = Double.parseDouble(maxDiag);
            if (minDiagFromUser > maxDiagFromUser || minDiagFromUser < 0) {
                System.out.printf("Некорректный ввод.%n");
            } else {
                int count = 0;
                for (Laptop item : listLaptops) {
                    if (item.getScreenDiagonal() >= minDiagFromUser && item.getScreenDiagonal() <= maxDiagFromUser) {
                        item.printLaptop();
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.printf("Нет в наличии.%n");
                }
            }
        } catch (NumberFormatException e) {
            System.out.printf("Некорректный ввод.%n");
        }
    }

    private static void filterByColor(ArrayList<Laptop> listLaptops) {
        String msg = "Введите желаемый цвет:\n";
        String dateFromUser = getDateFromUser(msg);
        int count = 0;
        for (Laptop item : listLaptops) {
            if (item.getColor().equals(dateFromUser)) {
                item.printLaptop();
                count++;
            }
        }
        if (count == 0) {
            System.out.printf("Такого цвета нет.%n");
        }
    }

    private static String getDateFromUser(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.printf(msg);
        String data = in.nextLine();
        while (data.isBlank()) {
            System.out.println("Ошибка ввода. Повторите ввод\n");
            System.out.println(msg);
            data = in.nextLine();
        } in. close();
        return data;
    } 
    private static void printAll(ArrayList<Laptop> listLaptops) {
        for (Laptop item : listLaptops) {
            item.printLaptop();
        }
    }
}