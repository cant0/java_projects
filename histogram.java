import java.util.Random;
import java.util.Scanner;

public class histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Daj n:");
        int n = scanner.nextInt();
        int[] numbers = new int[10];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int number = random.nextInt(10);
            numbers[number]++;
        }

        System.out.println("histogram:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < numbers[i]; j++) System.out.print("*");
            System.out.println();
        }
    }
}