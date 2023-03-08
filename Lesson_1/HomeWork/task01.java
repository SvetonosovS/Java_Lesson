package Lesson_1.HomeWork;

public class task01 {
    public static void main(String[] args) {
        findMinAndMax(); 
    }

    private static void findMinAndMax() {
        int[] arr = {1, 2, 5, 8, 4, 6, 9, 15, 0};
        int minNumber = arr[0];
        int maxNumber = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxNumber)
                maxNumber = arr[i];
            else if (arr[i] < minNumber)
                minNumber = arr[i];
        }
        System.out.println("Min number " + minNumber + "\n" + "Max number " + maxNumber);
    }
}
