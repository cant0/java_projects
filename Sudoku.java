import java.util.Scanner;

public class Sudoku {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int size = 9;
    private static final int grid = 3;

    public static void main(String[] args) {
        int[][] board = generateArray();
        printArray(board);
        System.out.println(validateSudoku(board));
    }

    private static int[][] generateArray() {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        return array;
    }

    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean validateSudoku(int[][] board) {
        boolean[][] rows = new boolean[size][size];
        boolean[][] cols = new boolean[size][size];
        boolean[][][] grids = new boolean[grid][grid][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) continue;
                int value = board[i][j] - 1;
                if (rows[i][value]) {
                    return false;
                }
                rows[i][value] = true;

                if (cols[j][value]) {
                    return false;
                }
                cols[j][value] = true;

                if (grids[i/3][j/3][value]) {
                    return false;
                }
                grids[i/3][j/3][value] = true;
            }
        }
        return true;
    }
}
