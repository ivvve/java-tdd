package tictactoe;

public class Record {
    private int win;
    private int lose;

    public int getWin() {
        return win;
    }

    public int getLose() {
        return lose;
    }

    public void addWin() {
        this.win++;
    }

    public void addLose() {
        this.lose++;
    }
}
