package TicTacToeAI;

import java.util.Scanner;

public class Game {

    public static String[][] board = {
            { " ", " ", " " },
            { " ", " ", " " },
            { " ", " ", " " }
    };
    public static final String human = "O";
    public static final String ai = "X";
    public static String currentPlayer = human;

    public void loop() {

        while (true) {
            printBoard();

            String state = isTerminalState();
            if (state != null) {
                if (state == "tie") {
                    System.out.println(state);
                    break;
                }
                System.out.println(state + " wins");
                break;
            }

            if (currentPlayer == human) {
                while (true) {
                    Scanner userInput = new Scanner(System.in);
                    System.out.println("x:");
                    int x = userInput.nextInt() - 1;
                    System.out.println("y:");
                    int y = userInput.nextInt() - 1;
                    if (isValidPosition(x, y)) {
                        board[x][y] = human;
                        break;
                    }

                }
                currentPlayer = ai;

            } else {
                Ai.bestMove();
                currentPlayer = human;
            }

        }
    }

    public static boolean isValidPosition(int x, int y) {
        if (board[x][y] == " ") {
            return true;
        }
        return false;
    }

    public static void printBoard() {
        System.out.println("\n");
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("---------");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("---------");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.println("\n");

    }

    public static String isTerminalState() {
        // check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][1] != " ") {
                return board[row][0];
            }
        }

        // check columns
        for (int column = 0; column < 3; column++) {
            if (board[0][column] == board[1][column] && board[1][column] == board[2][column]
                    && board[1][column] != " ") {
                return board[0][column];
            }
        }

        // check diagonal
        if (((board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0])) && board[1][1] != " ") {
            return board[1][1];
        }

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (board[row][column] == " ") {
                    return null;
                }
            }
        }
        return "tie";
    }
}