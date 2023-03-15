package Lesson_3.HomeWork;

import java.util.*;;

public class Task_3_2HW {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Введите размер массива: ");
        int sizeList = in.nextInt();
        ArrayList<Integer> rndList = new ArrayList<>();
        for (int i = 0; i < sizeList; i++) {
            rndList.add(r.nextInt( 101));
        }
        System.out.println("Созданный список: " + rndList);
        Collections.sort(rndList);
        System.out.println("MIN = " + rndList.get(0));
        System.out.println("MAX = " + rndList.get(rndList.size() - 1));
        System.out.println("Average = " + findAverage(rndList));
        in.close();
    }

    public static double findAverage(ArrayList<Integer> lst) {
        double sum = 0;
        for (int num : lst) {
            sum += num;
        }
        return sum / lst.size();
    }
}
