package Lesson_2.HomeWork;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task_2_2 {
    public static void main(String[] args) throws IOException {
    
    System.out.println("Java HW2. Task 2 - print TEST");
        Path file = Path.of("file_for_Task_2_2.txt");

        try {
            Files.createFile(file);
            Files.writeString(file, wordsGenerator("TEST", 100));
            if (Files.exists(file)) System.out.println("File has been created");
        } catch (IOException ex) {
            Files.writeString(file, wordsGenerator("TEST", 100));
            System.out.println("File has been already exist and was rewritten");
        }
    }
    public static String wordsGenerator(String value, int quantity) {
        StringBuilder creator = new StringBuilder();
        for (int i = 0; i < quantity; i++) {
            creator.append(value).append("\n");
        }
        return creator.toString();
    }
}
