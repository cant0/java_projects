import java.util.Random;

public class dice {
    public static void main(String[] args) {
        final Random random = new Random();
        final int limit = 30;
        int turn = random.nextInt(2);
        int sum1 = 0, sum2 = 0;
        while (true) {
            if (turn % 2 == 0) {
                sum1 += random.nextInt(1, 7);
                System.out.printf("Player 1 has %d points%n", sum1);
                if (sum1 >= limit) {
                    System.out.println("Player 1 wins");
                    break;
                }
            } else {
                sum2 += random.nextInt(1, 7);
                System.out.printf("Player 2 has %d points%n", sum2);
                if (sum2 >= limit) {
                    System.out.println("Player 2 wins");
                    break;
                }
            }++turn;
        }
    }
}
