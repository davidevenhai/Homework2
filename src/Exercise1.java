import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        biggerNumbers();
    }

    public static void biggerNumbers() {
        Scanner scanner = new Scanner(System.in);
        final int SIZE_ARRAY = 10;
        int[] array = new int[SIZE_ARRAY];
        int sum = 0;
        int avg = 0;
        System.out.println("Enter 10 numbers"); //Scan 10 numbers
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            sum = sum + array[i]; //Summary for all numbers
        }
        avg = sum / 10; //Calculate average
        System.out.println("The average is " + avg);
        for (int i = 0; i < array.length; i++) {
            if (array[i] > avg) {
                System.out.println(array[i]);
            } //Prints the numbers that are bigger than the average
        }
    }
}
