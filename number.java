import java.util.Random;

public class number {
    public static void main(String[] args) {
        final Random random = new Random();
        final int lowerLimit = 0;
        final int upperLimit = 100;
        final int numberToGuess = random.nextInt(lowerLimit, upperLimit);
        System.out.printf("Expected number is %d%n", numberToGuess);
        int low = lowerLimit;
        int high = upperLimit;
        int guessed = random.nextInt(low, high);
        System.out.printf("Guess from [%d, %d): %d%n", low, high, guessed);
        while (guessed != numberToGuess) {
            if (guessed < numberToGuess) {
                low = guessed + 1;
            } else {
                high = guessed;
            }
            guessed = random.nextInt(low, high);
            System.out.printf("Guess from [%d, %d): %d%n", low, high, guessed);
        }
        System.out.printf("Number is %d%n", guessed);
    }
}
