package Tests;

import org.junit.Assert;
import org.junit.Test;

import TicTacToeAI.Game;

public class TestGame {

    @Test
    public void testDefaultBoardSize() {
        Assert.assertEquals(3, Game.board.length);
        Assert.assertEquals(3, Game.board[0].length);
        Assert.assertEquals(3, Game.board[1].length);
        Assert.assertEquals(3, Game.board[2].length);
    }

    @Test
    public void testDefaultBoardValue() {
        for (String[] line : Game.board) {
            for (String element : line) {
                Assert.assertEquals(" ", element);
            }
        }
    }

    @Test
    public void testDefaultHumanValue() {
        Assert.assertEquals("O", Game.human);
    }

    @Test
    public void testDefaultAiValue() {
        Assert.assertEquals("X", Game.ai);
    }

    @Test
    public void testDefaultCurrentPlayerValue() {
        Assert.assertEquals("O", Game.currentPlayer);
    }
}
