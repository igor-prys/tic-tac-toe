import org.example.TicTacToe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    public void shouldCreateObject() {
        game = new TicTacToe();
    }
    @Test
    public void shouldCheckBorder() {
        game.addMove(-1, 0);
        game.addMove(4, 0);
        game.addMove(0, -1);
        game.addMove(0, 4);
        String expectedValue = "___\n___\n___\n";
        Assertions.assertEquals(expectedValue, game.toString());
    }
    @Test
    public void shouldCheckHorizontalWinner() {
        game.addMove(0, 0);
        game.addMove(1, 1);
        game.addMove(0, 1);
        game.addMove(1, 2);
        game.addMove(0, 2);
        Assertions.assertTrue(game.hasWinner());
    }
    @Test
    public void shouldCheckVerticalWinner() {
        game.addMove(0, 0);
        game.addMove(1, 1);
        game.addMove(1, 0);
        game.addMove(2, 2);
        game.addMove(2, 0);
        Assertions.assertTrue(game.checkVertical());
    }
    @Test
    public void shouldCheckLeftVertical() {
        game.addMove(0, 0);
        game.addMove(1, 0);
        game.addMove(1, 1);
        game.addMove(0, 1);
        game.addMove(2, 2);
        Assertions.assertTrue(game.checkLeftDiagonal());
    }
    @Test
    public void shouldCheckRightDiagonal() {
        game.addMove(0, 2);
        game.addMove(0, 1);
        game.addMove(1, 1);
        game.addMove(1, 0);
        game.addMove(2, 0);
        Assertions.assertTrue(game.checkRightDiagonal());
    }
    @Test
    public void shouldCheckDraw() {
        game.addMove(0, 0);
        game.addMove(1, 0);
        game.addMove(2, 0);
        game.addMove(2, 1);
        game.addMove(2, 2);
        game.addMove(1, 1);
        game.addMove(0, 1);
        game.addMove(0, 2);
        Assertions.assertFalse(game.draw());
        game.addMove(1, 2);
        Assertions.assertTrue(game.draw());
    }
}
