import java.util.Random;
import java.util.Scanner;

public class AntSimulation {

    static class Ant {
        int x, y;

        Ant(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Board {
        int size;
        boolean[][] cells;

        Board(int size, int initialAnts) {
            this.size = size;
            cells = new boolean[size][size];


            Random random = new Random();
            for (int i = 0; i < initialAnts; i++) {
                int x = random.nextInt(size);
                int y = random.nextInt(size);
                cells[x][y] = true;
            }
        }

        synchronized void moveAnt(Ant ant) {
            Random random = new Random();
            int newX, newY;

            do {
                int direction = random.nextInt(8);
                newX = ant.x + dx[direction];
                newY = ant.y + dy[direction];
            } while (newX < 0 || newX >= size || newY < 0 || newY >= size);

            if (!cells[newX][newY]) {
                cells[ant.x][ant.y] = false;
                ant.x = newX;
                ant.y = newY;
                cells[newX][newY] = true;
                System.out.println("Ant moved to: (" + ant.x + ", " + ant.y + ")");
            } else {
                System.out.println("Ant stayed at: (" + ant.x + ", " + ant.y + ")");
            }
        }

        void printBoard() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(cells[i][j] ? "A " : ". ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the board size: ");
        int size = scanner.nextInt();

        System.out.print("Enter the number of initial ants: ");
        int initialAnts = scanner.nextInt();

        Board board = new Board(size, initialAnts);

        for (int i = 0; i < initialAnts; i++) {
            Ant ant = new Ant(new Random().nextInt(size), new Random().nextInt(size));
            new Thread(() -> simulateAntLife(ant, board)).start();
        }
    }

    static void simulateAntLife(Ant ant, Board board) {
        Random random = new Random();

        while (true) {
            try {
                Thread.sleep(random.nextInt(1000) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            board.moveAnt(ant);
            board.printBoard();

            if (ant.x < 0 || ant.x >= board.size || ant.y < 0 || ant.y >= board.size) {
                System.out.println("Ant died. New ant born at random position.");
                ant.x = random.nextInt(board.size);
                ant.y = random.nextInt(board.size);
                board.cells[ant.x][ant.y] = true;
            }
        }
    }
}
