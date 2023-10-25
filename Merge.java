import java.util.Arrays;
import java.util.Random;

import static java.lang.System.*;

public class Merge {

    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] array1 = fillArray();
        int[] array2 = fillArray();
        out.println(Arrays.toString(array1));
        out.println(Arrays.toString(array2));
        out.println();

        bubbleSort(array1);
        bubbleSort(array2);
        out.println(Arrays.toString(array1));
        out.println(Arrays.toString(array2));
        out.println();

        int[] result = merge(array1, array2);
        out.println(Arrays.toString(result));
    }

    private static int[] fillArray() {
        int[] array = new int[random.nextInt(5, 15)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 10);
        }
        return array;
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean change = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    change = true;
                }
            }
            if (!change) return;
        }
    }

    private static int[] merge(int[] array1, int[] array2) {
        int[] array3 = new int[array1.length + array2.length];
        int i1 = 0, i2 = 0, i3 = 0;
        while (i1 < array1.length && i2 < array2.length) {
            if (array1[i1] < array2[i2]) {
                if (i3 == 0 || array3[i3 - 1] != array1[i1]) {
                    array3[i3++] = array1[i1];
                }
                ++i1;
            } else {
                if (i3 == 0 || array3[i3 - 1] != array2[i2]) {
                    array3[i3++] = array2[i2];
                }
                ++i2;
            }
        }

        while (i1 < array1.length) {
            if (i3 == 0 || array3[i3 - 1] != array1[i1]) {
                array3[i3++] = array1[i1];
            }
            ++i1;
        }

        while (i2 < array2.length) {
            if (i3 == 0 || array3[i3 - 1] != array2[i2]) {
                array3[i3++] = array2[i2];
            }
            ++i2;
        }

        int[] result = new int[i3];
        arraycopy(array3, 0, result, 0, result.length);

        return result;
    }
}
