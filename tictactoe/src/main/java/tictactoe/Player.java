package tictactoe;

public class Player {
    private String name;
    private int win;
    private int lose;

    public Player(String name) {
        this.name = name;
    }

    public int getWin() {
        return win;
    }

    public int getLose() {
        return lose;
    }

    public void win() {
        this.win++;
    }

    public void lose() {
        this.lose++;
    }

    public String csvFormat() {
        return new StringBuilder()
                .append(this.name).append(",")
                .append(this.win).append(",")
                .append(this.lose)
                .toString();
    }
}
