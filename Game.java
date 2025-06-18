import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public Game(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = p1; // p1 always starts
        this.board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        board.printBoard();

        while (true) {
            System.out.println("\n" + currentPlayer.getName() + " (" + currentPlayer.getSymbol() + "), enter your move (row and column 0-2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.placeSymbol(row, col, currentPlayer.getSymbol())) {
                board.printBoard();

                if (checkWin(currentPlayer.getSymbol())) {
                    System.out.println("🎉 " + currentPlayer.getName() + " wins!");
                    break;
                } else if (board.isFull()) {
                    System.out.println("It's a draw!");
                    break;
                }

                switchPlayer();
            } else {
                System.out.println("Try again.");
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean checkWin(char symbol) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board.getCellValue(i, 0) == symbol && board.getCellValue(i, 1) == symbol && board.getCellValue(i, 2) == symbol)
                return true;
            if (board.getCellValue(0, i) == symbol && board.getCellValue(1, i) == symbol && board.getCellValue(2, i) == symbol)
                return true;
        }

        if (board.getCellValue(0, 0) == symbol && board.getCellValue(1, 1) == symbol && board.getCellValue(2, 2) == symbol)
            return true;
        if (board.getCellValue(0, 2) == symbol && board.getCellValue(1, 1) == symbol && board.getCellValue(2, 0) == symbol)
            return true;

        return false;
    }
}