package racing.domain;

import racing.domain.generator.NumberGenerator;
import racing.vo.Distance;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int INITIAL_DISTANCE = 0;

    private final String name;
    private final NumberGenerator numberGenerator;
    private Distance distance;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
        this.distance = new Distance(INITIAL_DISTANCE);
    }

    @Override
    public String toString() {
        return this.name + " : " + this.distance;
    }

    void move() {
        move(numberGenerator.generate());
    }

    Distance getDistance() {
        return distance;
    }

    int getDistanceValue() {
        return this.distance.getValue();
    }

    private void move(int value) {
        if (MOVE_THRESHOLD <= value) {
            this.distance = this.distance.increment();
        }
    }
}
