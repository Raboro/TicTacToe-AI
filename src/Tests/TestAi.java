package Tests;

import org.junit.Assert;
import org.junit.Test;

import TicTacToeAI.Ai;
import TicTacToeAI.Game;

public class TestAi {

    @Test
    public void TestAiMoveX0Y0() {

        String[][] result = {
                { "X", " ", " " },
                { " ", " ", " " },
                { " ", " ", " " }
        };

        Ai.bestMove();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Assert.assertEquals(result[x][y], Game.board[x][y]);
            }
        }
    }

    @Test
    public void TestAiMoveX0Y1() {

        String[][] result = {
                { "X", "X", " " },
                { " ", "O", " " },
                { " ", " ", " " }
        };

        Game.board[1][1] = Game.HUMAN;

        Ai.bestMove();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Assert.assertEquals(result[x][y], Game.board[x][y]);
            }
        }
    }

    @Test
    public void TestAiMoveX2Y0() {

        String[][] result = {
                { "X", "X", "O" },
                { " ", "O", " " },
                { "X", " ", " " }
        };

        Game.board[0][2] = Game.HUMAN;

        Ai.bestMove();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Assert.assertEquals(result[x][y], Game.board[x][y]);
            }
        }
    }
}
