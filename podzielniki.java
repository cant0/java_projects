import java.util.Scanner;

public class podzielniki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę całkowitą:");
        int n = scanner.nextInt();
        System.out.println("Podzielniki liczby " + n + " to:");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }
}