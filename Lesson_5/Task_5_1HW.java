package Lesson_5;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.*;;

public class Task_5_1HW {
    public static void main(String[] args) {
        HashMap<String, LinkedList<String>> phoneBook = new HashMap<>();
        LinkedList<String> first = new LinkedList<>();
        Collections.addAll(first, "111111", "222222");
        LinkedList<String> second = new LinkedList<>();
        Collections.addAll(second, "3333333", "4444444");
        LinkedList<String> third = new LinkedList<>();
        Collections.addAll(third, "5555555");
        LinkedList<String> fourth = new LinkedList<>();
        Collections.addAll(fourth, "6666666", "77777777", "88888888");
        phoneBook.put("Иванов Петр", first);
        phoneBook.put("Петров Федор", second);
        phoneBook.put("Федорова Алиса", third);
        phoneBook.put("Иванова Елена", fourth);
//        System.out.println(phoneBook);
        startPhoneBook(phoneBook);
    }

    private static void startPhoneBook(HashMap<String, LinkedList<String>> phoneBook) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.printf("%nДля продолжения нажмите: %n" +
                    " Показать все записи: 11%n" +
                    " Найти контакт: 2%n" +
                    " Найти телефон: 3%n" +
                    " Удалить запись: 4%n" +
                    " Удалить один из номеров: 5%n" +
                    " Добавить новый контакт: 6%n" +
                    " Добавить телефон к существующему контакту: 7%n" +
                    " Изменить контакт: 8%n" +
                    " Выйти из программы: 0%n");

            String inputString = in.nextLine();

            if (inputString.isBlank()) {
                System.out.println("Строка не должна быть пустой. Введите данные\n");
                continue;
            }

            if (inputString.equalsIgnoreCase("0")) {
                System.out.println("Работа завершена.\n");
                break;
            }

            if (inputString.equalsIgnoreCase("11")) {
                printAll(phoneBook);
                continue;
            }

            if (inputString.equalsIgnoreCase("2")) {
                findPerson(phoneBook);
                continue;
            }

            if (inputString.equalsIgnoreCase("3")) {
                findPhone(phoneBook);
                continue;
            }

            if (inputString.equalsIgnoreCase("4")) {
                deletePerson(phoneBook);
                continue;
            }

            if (inputString.equalsIgnoreCase("5")) {
                deletePhone(phoneBook);
                continue;
            }

            if (inputString.equalsIgnoreCase("6")) {
                addNewPerson(phoneBook);
                continue;
            }

            if (inputString.equalsIgnoreCase("7")) {
                addNewPhone(phoneBook);
                continue;
            }

            if (inputString.equalsIgnoreCase("8")) {
                changeDateFromUser(phoneBook);

            } else {
                System.out.println("Такого действия не существует. Введите действие еще раз\n");
            }
        }
    }

    private static void changeDateFromUser(HashMap<String, LinkedList<String>> phoneBook) {
        String msg1 = "Введите имя записи, подлежащее замене:\n";
        String name = getDateFromUser(msg1);
        if (phoneBook.containsKey(name)) {
            String msg2 = "Введите новые фамилию и имя:\n";
            String newName = getDateFromUser(msg2);
            LinkedList<String> UserPhones = phoneBook.get(name);
            phoneBook.put(newName, UserPhones);
            phoneBook.remove(name);
            System.out.println("Имя и фамилия успешно изменены.\n");
        } else {
            System.out.println("Такой записи нет.\n");
        }
    }

    private static void addNewPhone(HashMap<String, LinkedList<String>> phoneBook) {
        String msg1 = "Введите фамилию и имя через пробел:\n";
        String nameFromUser = getDateFromUser(msg1);
        if (phoneBook.containsKey(nameFromUser)) {
            String msg2 = "Введите новый номер:\n";
            String phoneFromUser = getDateFromUser(msg2);
            LinkedList<String> phoneNumbers = phoneBook.get(nameFromUser);
            if (phoneNumbers.contains(phoneFromUser)) {
                System.out.printf("У записи %s номер %s уже сохранён.%n", nameFromUser, phoneFromUser);
            } else {
                phoneNumbers.add(phoneFromUser);
                phoneBook.put(nameFromUser, phoneNumbers);
                System.out.printf("К записи %s добавлен номер %s%n", nameFromUser, phoneFromUser);
            }
        } else {
            System.out.printf("Такой записи нет в телефонной книге.%n");
        }
    }

    private static void addNewPerson(HashMap<String, LinkedList<String>> phoneBook) {
        String msg1 = "Введите фамилию и имя через пробел:\n";
        String name = getDateFromUser(msg1);
        if (phoneBook.containsKey(name)) {
            System.out.printf("Такой пользователь уже есть в телефонной книге!%n");
        } else {
            String msg2 = "Введите новый номер:%n";
            String phone = getDateFromUser(msg2);
            LinkedList<String> phoneNumbers = new LinkedList<>();
            phoneNumbers.add(phone);
            phoneBook.put(name, phoneNumbers);
            System.out.printf("Новая запись %s и номер %s успешно добалены%n", name, phone);
        }

    }

    private static void deletePhone(HashMap<String, LinkedList<String>> phoneBook) {
        String msg1 = "Введите фамилию и имя через пробел:\n";
        String name = getDateFromUser(msg1);
        if (phoneBook.containsKey(name)) {
            String msg2 = "Введите номер для удаления: \n";
            String phoneFromUser = getDateFromUser(msg2);
            LinkedList<String> phoneNumbers = phoneBook.get(name);
            int count = 0;
            for (String phone : phoneNumbers) {
                if (phone.equals(phoneFromUser)) {
                    System.out.printf("У записи %s удалён номер %s.%n", name, phone);
                    phoneNumbers.remove(phone);
                    count++;
                }
            }
            if (count == 0) {
                System.out.printf("У записи %s не найден номер %s.%n", name, phoneFromUser);
            }
        } else {
            System.out.printf("Такой записи нет в телефонной книге.%n");
        }
    }

    private static void deletePerson(HashMap<String, LinkedList<String>> phoneBook) {
        String msg = "Введите фамилию и имя через пробел:\n";
        String name = getDateFromUser(msg);
        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            System.out.printf("Удаление записи %s из телефонной книги прошло успешно!%n", name);
        } else {
            System.out.printf("Такой записи нет в телефонной книге.%n");
        }
    }

    private static void findPhone(HashMap<String, LinkedList<String>> phoneBook) {
        String msg = "Введите номер телефона для поиска:\n";
        String number = getDateFromUser(msg);
        int count = 0;
        for (Map.Entry<String, LinkedList<String>> item : phoneBook.entrySet()) {
            String name = item.getKey();
            LinkedList<String> phoneNumbers = item.getValue();
            for (String phone : phoneNumbers) {
                if (phone.equalsIgnoreCase(number)) {
                    System.out.printf("Номер %s принадлежит %s%n", number, name);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.printf("Номер %s отсутсвует в телефонной книге.%n", number);
        }
    }

    private static void findPerson(HashMap<String, LinkedList<String>> phoneBook) {
        String msg = "Введите фамилию и имя через пробел или часть имени/фамилии:\n";
        String dateFromUser = getDateFromUser(msg);
        if (phoneBook.containsKey(dateFromUser)) {
            LinkedList<String> phoneNumbers = phoneBook.get(dateFromUser);
            System.out.printf("Телефоны %s:%n", dateFromUser);
            for (String phone : phoneNumbers) {
                System.out.printf("%s%n", phone);
            }
        } else {
            int count = 0;
            for (Map.Entry<String, LinkedList<String>> item : phoneBook.entrySet()) {
                String name = item.getKey();
                if (name.contains(dateFromUser)) {
                    LinkedList<String> phoneNumbers = phoneBook.get(name);
                    System.out.printf("Запись \"%s\", содержит искомое \"%s\":%n", name, dateFromUser);
                    for (String phone : phoneNumbers) {
                        System.out.printf("%s%n", phone);
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.printf("Такой записи нет в телефонной книге.%n");
            }
        }
    }

    private static String getDateFromUser(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.printf(msg);
        String data = in.nextLine();
        while (data.isBlank()) {
            System.out.println("Строка не должна быть пустой. Введите данные\n");
            System.out.println(msg);
            data = in.nextLine();
        }
        return data;
    }

    private static void printAll(HashMap<String, LinkedList<String>> phoneBook) {
        TreeMap<String, LinkedList<String>> phoneBookTreeMap = new TreeMap<>(Comparator.naturalOrder());
        phoneBookTreeMap.putAll(phoneBook);
        for (Map.Entry<String, LinkedList<String>> elem : phoneBookTreeMap.entrySet()) {
            String dateFromUser = elem.getKey();
            LinkedList<String> phoneNumbers = elem.getValue();
            System.out.printf("Телефон(ы)  %s:%n", dateFromUser);
            for (String phone : phoneNumbers) {
                System.out.printf("%s%n", phone);
            }
        }
    }
}
