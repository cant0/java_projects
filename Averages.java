import java.util.Arrays;
import java.util.Random;

public class Averages {
    private static final Random random = new Random();

    public static void main(String[] args) {
        double[] array = new double[random.nextInt(10, 20)];
        fillArray(array);
        System.out.println(Arrays.toString(array));
        double[] result = averages(array);
        System.out.println(Arrays.toString(result));
    }

    private static void fillArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    private static double[] averages(double[] array) {
        double[] result = new double[(array.length + 1) / 2];
        for (int i = 0; i < result.length - 1; i++) {
            result[i] = (array[2*i] + array[2*i + 1]) / 2.;
        }
        if (array.length % 2 == 1) {
            result[result.length - 1] = array[array.length - 1];
        } else {
            result[result.length - 1] = (array[array.length - 1] + array[array.length - 2]) / 2.;
        }
        return result;
    }
}

