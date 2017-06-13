package bowlinggame;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class BowlingGameTest {

    private BowlingGame game;

    @Before
    public void setUp() {
        game = new BowlingGame();
    }

    @Test
    public void allRollsMissed() {
        rollMany(20, 0);
        assertThat("Le score est incorrect.", 0, is(game.score()));
    }

    @Test
    public void allRollsOne() {
        rollMany(20, 1);
        assertThat("Le score est incorrect.", 20, is(game.score()));
    }

    @Test
    public void oneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertThat("Le score du spare est incorrect.", 16, is(game.score()));
    }

    @Test
    public void oneStrike() {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertThat("Le score du strike est incorrect.", 24, is(game.score()));
    }

    @Test
    public void perfectGame() {
        rollMany(12, 10);
        assertThat("Le score du jeu parfait est incorrect.", 300, is(game.score()));
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int nbRolls, int pins) {
        for (int i = 0; i < nbRolls; i++) {
            game.roll(pins);
        }
    }

}
