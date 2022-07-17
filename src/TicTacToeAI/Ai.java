package TicTacToeAI;

public class Ai {

    public static void bestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] move = new int[2];

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (Game.board[row][column] == " ") {
                    Game.board[row][column] = Game.ai;
                    int score = miniMax(Game.board, false);
                    Game.board[row][column] = " ";

                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = row;
                        move[1] = column;
                    }
                }
            }
        }
        Game.board[move[0]][move[1]] = Game.ai;
    }

    private static int miniMax(String[][] board, boolean isMaximasing) {
        if (Game.isTerminalState() != null) {
            return scores(Game.isTerminalState());
        }

        if (isMaximasing) {
            int bestScoreMax = Integer.MIN_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    if (Game.board[row][column] == " ") {
                        Game.board[row][column] = Game.ai;
                        int scoreMax = miniMax(board, false);
                        Game.board[row][column] = " ";

                        if (scoreMax > bestScoreMax) {
                            bestScoreMax = scoreMax;
                        }
                    }
                }
            }
            return bestScoreMax;
        } else {
            int bestScoreMax = Integer.MAX_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    if (Game.board[row][column] == " ") {
                        Game.board[row][column] = Game.human;
                        int scoreMax = miniMax(board, true);
                        Game.board[row][column] = " ";

                        if (scoreMax < bestScoreMax) {
                            bestScoreMax = scoreMax;
                        }
                    }
                }
            }
            return bestScoreMax;
        }
    }

    private static int scores(String result) {
        if (result == "X") {
            return 1;
        } else if (result == "O") {
            return -1;
        } else {
            return 0;
        }
    }
}