package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    private Player player1;
    private String player1Name = "Chris";
    private Player player2;
    private String player2Name = "Erin";

    @Before
    public void playerInit() {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    @Test
    public void player_getWin_과_getLose_test() {
        assertThat(player1.getWin(), is(0));
        assertThat(player1.getLose(), is(0));
        assertThat(player2.getWin(), is(0));
        assertThat(player2.getLose(), is(0));
    }

    @Test
    public void player_win_과_lose_test() {
        player1.win();
        player2.lose();
        assertThat(player1.getWin(), is(1));
        assertThat(player1.getLose(), is(0));
        assertThat(player2.getWin(), is(0));
        assertThat(player2.getLose(), is(1));

        player1.lose();
        player2.win();
        assertThat(player1.getWin(), is(1));
        assertThat(player1.getLose(), is(1));
        assertThat(player2.getWin(), is(1));
        assertThat(player2.getLose(), is(1));

        player1.lose();
        player2.win();
        assertThat(player1.getWin(), is(1));
        assertThat(player1.getLose(), is(2));
        assertThat(player2.getWin(), is(2));
        assertThat(player2.getLose(), is(1));
    }

    @Test
    public void player_csvFormat_test() {
        player1.win();
        player1.win();
        player1.win();
        player1.lose();
        player1.lose();

        String hardCodedCsvFormat = "Chris,3,2";

        assertThat(player1.csvFormat(), is(hardCodedCsvFormat));
    }
}
