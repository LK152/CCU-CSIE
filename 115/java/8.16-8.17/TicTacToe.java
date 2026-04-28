import java.util.Scanner;

public class TicTacToe {
    public enum Cell {
        O, X, EMPTY
    };

    private Cell[][] bd;

    public TicTacToe() {
        bd = new Cell[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bd[i][j] = Cell.EMPTY;
            }
        }
    }

    public void printBd() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print((bd[i][j] == Cell.EMPTY ? " " : bd[i][j]) + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public boolean move(int row, int col, Cell ply) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && bd[row][col] == Cell.EMPTY) {
            bd[row][col] = ply;
            return true;
        }
        return false;
    }

    public boolean checkWin(Cell ply) {
        for (int i = 0; i < 3; i++) {
            if (bd[i][0] == ply && bd[i][1] == ply && bd[i][2] == ply)
                return true;
            if (bd[0][i] == ply && bd[1][i] == ply && bd[2][i] == ply)
                return true;
        }
        if (bd[0][0] == ply && bd[1][1] == ply && bd[2][2] == ply)
            return true;
        if (bd[0][2] == ply && bd[1][1] == ply && bd[2][0] == ply)
            return true;

        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (bd[i][j] == Cell.EMPTY)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        Cell currentPly = Cell.X;

        System.out.println("Tic-Tac-Toe Game Started!");
        game.printBd();

        while (true) {
            System.out.printf("ply %s, enter row (0-2) and column (0-2): ", currentPly);

            if (scanner.hasNextInt()) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (game.move(row, col, currentPly)) {
                    game.printBd();

                    if (game.checkWin(currentPly)) {
                        System.out.println("ply " + currentPly + " wins!");
                        break;
                    } else if (game.isDraw()) {
                        System.out.println("It's a draw!");
                        break;
                    }

                    currentPly = (currentPly == Cell.X) ? Cell.O : Cell.X;
                } else {
                    System.out.println("Invalid move. Cell is either taken or out of bounds. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter numbers.");
                scanner.next();
            }
        }
        scanner.close();
    }
}