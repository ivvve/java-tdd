package tictactoe;

public class Player {
    private String name;
    private Record record;

    public Player(String name) {
        this.name = name;
        this.record = new Record();
    }

    public Record getRecord() {
        return this.record;
    }

    public void win() {
        this.record.addWin();
    }

    public void lose() {
        this.record.addLose();
    }

    public String csvFormat() {
        return new StringBuilder()
                .append(this.name).append(",")
                .append(this.record.getWin()).append(",")
                .append(this.record.getLose())
                .toString();
    }
}
