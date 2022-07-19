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
        Assert.assertEquals("O", Game.HUMAN);
    }

    @Test
    public void testDefaultAiValue() {
        Assert.assertEquals("X", Game.AI);
    }

    @Test
    public void testDefaultCurrentPlayerValue() {
        Assert.assertEquals("O", Game.currentPlayer);
    }

    @Test
    public void testIsValidPositionTrue() {
        Assert.assertTrue(Game.isValidPosition(0, 0));
        Assert.assertTrue(Game.isValidPosition(1, 2));
        Assert.assertTrue(Game.isValidPosition(2, 2));
        Assert.assertTrue(Game.isValidPosition(0, 2));
        Assert.assertTrue(Game.isValidPosition(1, 0));
    }

    @Test
    public void testIsValidPositionFalse() {
        Game.board[0][0] = "O";
        Game.board[1][2] = "X";
        Game.board[2][2] = "X";
        Game.board[0][2] = "X";
        Game.board[1][0] = "O";

        Assert.assertFalse(Game.isValidPosition(0, 0));
        Assert.assertFalse(Game.isValidPosition(1, 2));
        Assert.assertFalse(Game.isValidPosition(2, 2));
        Assert.assertFalse(Game.isValidPosition(0, 2));
        Assert.assertFalse(Game.isValidPosition(1, 0));

        Game.board[0][0] = " ";
        Game.board[1][2] = " ";
        Game.board[2][2] = " ";
        Game.board[0][2] = " ";
        Game.board[1][0] = " ";
    }

    @Test
    public void testIsTerminalStateNull() {
        Assert.assertNull(Game.isTerminalState());
        Game.board[0][0] = "X";
        Assert.assertNull(Game.isTerminalState());
        Game.board[1][0] = "X";
        Assert.assertNull(Game.isTerminalState());
        Game.board[2][0] = "0";
        Assert.assertNull(Game.isTerminalState());
        Game.board[0][0] = " ";
        Game.board[1][0] = " ";
        Game.board[2][0] = " ";
    }

    @Test
    public void testIsTerminalStateTie() {
        Game.board[0][0] = "O";
        Game.board[0][1] = "X";
        Game.board[0][2] = "O";
        Game.board[1][0] = "X";
        Game.board[1][1] = "O";
        Game.board[1][2] = "X";
        Game.board[2][0] = "X";
        Game.board[2][1] = "O";
        Game.board[2][2] = "X";

        Assert.assertEquals("tie", Game.isTerminalState());

        Game.board[0][0] = " ";
        Game.board[0][1] = " ";
        Game.board[0][2] = " ";
        Game.board[1][0] = " ";
        Game.board[1][1] = " ";
        Game.board[1][2] = " ";
        Game.board[2][0] = " ";
        Game.board[2][1] = " ";
        Game.board[2][2] = " ";
    }

    @Test
    public void testIsTerminalStateHuman() {
        Game.board[0][0] = "O";
        Game.board[0][1] = "X";
        Game.board[0][2] = "O";
        Game.board[1][0] = "X";
        Game.board[1][1] = "O";
        Game.board[1][2] = "X";
        Game.board[2][0] = "X";
        Game.board[2][1] = "O";
        Game.board[2][2] = "O";

        Assert.assertEquals(Game.HUMAN, Game.isTerminalState());

        Game.board[2][2] = "X";
        Game.board[2][0] = "O";

        Assert.assertEquals(Game.HUMAN, Game.isTerminalState());

        Game.board[1][0] = "O";
        Game.board[2][2] = "X";

        Assert.assertEquals(Game.HUMAN, Game.isTerminalState());


        Game.board[0][0] = " ";
        Game.board[0][1] = " ";
        Game.board[0][2] = " ";
        Game.board[1][0] = " ";
        Game.board[1][1] = " ";
        Game.board[1][2] = " ";
        Game.board[2][0] = " ";
        Game.board[2][1] = " ";
        Game.board[2][2] = " ";
    }

    @Test
    public void testIsTerminalStateAi() {
        Game.board[0][0] = "X";
        Game.board[0][1] = "O";
        Game.board[0][2] = "X";
        Game.board[1][0] = "O";
        Game.board[1][1] = "X";
        Game.board[1][2] = "O";
        Game.board[2][0] = "O";
        Game.board[2][1] = "X";
        Game.board[2][2] = "X";

        Assert.assertEquals(Game.AI, Game.isTerminalState());

        Game.board[2][2] = "O";
        Game.board[2][0] = "X";

        Assert.assertEquals(Game.AI, Game.isTerminalState());

        Game.board[1][0] = "X";
        Game.board[2][2] = "O";

        Assert.assertEquals(Game.AI, Game.isTerminalState());


        Game.board[0][0] = " ";
        Game.board[0][1] = " ";
        Game.board[0][2] = " ";
        Game.board[1][0] = " ";
        Game.board[1][1] = " ";
        Game.board[1][2] = " ";
        Game.board[2][0] = " ";
        Game.board[2][1] = " ";
        Game.board[2][2] = " ";
    }
}