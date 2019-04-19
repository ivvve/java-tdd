package racing.domain;

import racing.domain.generator.NumberGenerator;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final NumberGenerator numberGenerator;
    private int distance = 0;

    public Car(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void move() {
        move(numberGenerator.generate());
    }

    private void move(int value) {
        if (MOVE_THRESHOLD <= value) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }
}
