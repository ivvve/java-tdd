package racing.domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private int distance = 0;

    public void move(int value) {
        if (MOVE_THRESHOLD <= value) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }
}
