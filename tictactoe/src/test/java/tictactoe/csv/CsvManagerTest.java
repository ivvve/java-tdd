package tictactoe.csv;

import org.junit.Test;
import tictactoe.Player;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CsvManagerTest {
    @Test
    public void csvManager_savePlayer_readPlayer_test() throws IOException {
        Player player = new Player("Chris");
//        player.win();
//        player.win();
//        player.lose();
//        player.lose();

        CsvManager csvManager = new CsvManager();

        Player savedPlayer = csvManager.savePlayer(player);
        Player readPlayer = csvManager.readPlayer(player);

        assertThat(player, is(savedPlayer));
        assertThat(player, is(readPlayer));
        assertThat(savedPlayer, is(readPlayer));
    }

}
