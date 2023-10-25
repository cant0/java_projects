import java.util.Random;
import java.util.Scanner;

public class GameOfLife {
    private final int size;
    private boolean[][] board;

    public GameOfLife(int size) {
        this.size = size;
        this.board = new boolean[size][size];
        initializeBoard();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameOfLife gameOfLife = new GameOfLife(10);

        while (true) {
            gameOfLife.printBoard();
            gameOfLife.nextGeneration();
            scanner.nextLine();
        }
    }

    private void initializeBoard() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = random.nextDouble() < 0.3;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] ? "*" : " ");
            }
            System.out.println();
        }
    }

    public void nextGeneration() {
        boolean[][] newBoard = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int liveNeighbours = countLiveNeighbours(i, j);

                if (board[i][j]) {
                    newBoard[i][j] = liveNeighbours == 2 || liveNeighbours == 3;
                } else {
                    newBoard[i][j] = liveNeighbours == 3;
                }
            }
        }

        board = newBoard;
    }

    private int countLiveNeighbours(int row, int col) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;

                int newRow = row + i;
                int newCol = col + j;

                if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size && board[newRow][newCol]) {
                    count++;
                }
            }
        }

        return count;
    }
}