package Lesson_5;

import java.util.*;

public class Task_5_2HW {
    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        String persons = "Иван Иванов " +
                "Светлана Петрова " +
                "Кристина Белова " +
                "Анна Мусина " +
                "Анна Крутова " +
                "Иван Юрин " +
                "Петр Лыков " +
                "Павел Чернов " +
                "Петр Чернышов " +
                "Мария Федорова " +
                "Марина Светлова " +
                "Мария Савина " +
                "Мария Рыкова " +
                "Марина Лугова " +
                "Анна Владимирова " +
                "Иван Мечников " +
                "Петр Петин " +
                "Иван Ежов ";
        String[] listOfPersons = persons.split(" ");
        for (int i = 0; i < listOfPersons.length; i += 2) {
            if (nameMap.containsKey(listOfPersons[i])) {
                nameMap.replace(listOfPersons[i], nameMap.get(listOfPersons[i]) + 1);
            } else {
                nameMap.put(listOfPersons[i], 1);
            }
        }
        
        Map<String, Integer> sortedNameMap = new LinkedHashMap<>();
        int max = 1;
        for (int value : nameMap.values()) {
            if (value > max) {
                max = value;
            }
        }
        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
                String key = entry.getKey();
                if (nameMap.get(key) == i) {
                    sortedNameMap.put(key, nameMap.get(key));
                }
            }
        }
        System.out.println(sortedNameMap);
        System.out.println(persons);
    }
}