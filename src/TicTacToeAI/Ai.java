package TicTacToeAI;

public class Ai {

    public static void bestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] move = new int[2];

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (Game.board[row][column] == " ") {
                    Game.board[row][column] = Game.AI;
                    int score = miniMax(false);
                    Game.board[row][column] = " ";

                    // new best move
                    if (score > bestScore) { 
                        bestScore = score;
                        move[0] = row;
                        move[1] = column;
                    }
                }
            }
        }
        Game.board[move[0]][move[1]] = Game.AI; // AI do the move
    }

    private static int miniMax(boolean isMaximasing) {
        // is game over
        if (Game.isTerminalState() != null) {
            return scores(Game.isTerminalState());
        }
        
        if (isMaximasing) {
            int bestScoreMax = Integer.MIN_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    if (Game.board[row][column] == " ") {
                        Game.board[row][column] = Game.AI;
                        int scoreMax = miniMax(false);
                        Game.board[row][column] = " ";
                        bestScoreMax = Math.max(scoreMax, bestScoreMax);
                    }
                }
            }
            return bestScoreMax;
        } else {
            int bestScoreMin = Integer.MAX_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    if (Game.board[row][column] == " ") {
                        Game.board[row][column] = Game.HUMAN;
                        int scoreMin = miniMax(true);
                        Game.board[row][column] = " ";
                        bestScoreMin = Math.min(scoreMin, bestScoreMin);
                    }
                }
            }
            return bestScoreMin;
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