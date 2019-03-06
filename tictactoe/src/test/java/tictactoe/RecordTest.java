package tictactoe;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RecordTest {

    @Test
    public void record_getWin_getLose_test() {
        Record record = new Record();
        assertThat(record.getWin(), is(0));
        assertThat(record.getLose(), is(0));
    }

    @Test
    public void record_addWin_addLose_test() {
        Record record = new Record();

        record.addWin();
        assertThat(record.getWin(), is(1));
        assertThat(record.getLose(), is(0));

        record.addWin();
        assertThat(record.getWin(), is(2));
        assertThat(record.getLose(), is(0));

        record.addLose();
        assertThat(record.getWin(), is(2));
        assertThat(record.getLose(), is(1));

        record.addLose();
        assertThat(record.getWin(), is(2));
        assertThat(record.getLose(), is(2));
    }

}
