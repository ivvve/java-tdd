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
    public void player_getRecord_test() {
        Record player1Record = player1.getRecord();
        assertThat(player1Record.getWin(), is(0));
        assertThat(player1Record.getLose(), is(0));
    }

    @Test
    public void player_win_과_lose_test() {
        player1.win();
        player2.lose();
        Record player1Record = player1.getRecord();
        Record player2Record = player2.getRecord();
        assertThat(player1Record.getWin(), is(1));
        assertThat(player1Record.getLose(), is(0));
        assertThat(player2Record.getWin(), is(0));
        assertThat(player2Record.getLose(), is(1));

        player1.lose();
        player2.win();
        assertThat(player1Record.getWin(), is(1));
        assertThat(player1Record.getLose(), is(1));
        assertThat(player2Record.getWin(), is(1));
        assertThat(player2Record.getLose(), is(1));

        player1.lose();
        player2.win();
        assertThat(player1Record.getWin(), is(1));
        assertThat(player1Record.getLose(), is(2));
        assertThat(player2Record.getWin(), is(2));
        assertThat(player2Record.getLose(), is(1));
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
