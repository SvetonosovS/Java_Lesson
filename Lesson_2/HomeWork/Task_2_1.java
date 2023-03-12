package Lesson_2.HomeWork;
import java.util.Scanner;

public class Task_2_1 {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter word: ");
        String userWord = in.nextLine();
        in.close();

        if (userWord.length() == 0) {
            System.out.println("Строка пуста");
        } else if (userWord.length() == 1) {
            System.out.printf("В %s только 1 символ", userWord);
        }

        boolean resultdeterminesPalindrome = determinesPalindrome(userWord);
        if (resultdeterminesPalindrome) {
            System.out.printf(" %s является палиндромом", userWord);
        } else {
            System.out.printf("%s  не является палиндромом", userWord);
        }
    }

    private static boolean determinesPalindrome(String userWord) {
        for (int i = 0; i < userWord.length() / 2; i++) {
            if (userWord.charAt(i) != userWord.charAt(userWord.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

