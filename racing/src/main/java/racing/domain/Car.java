package racing.domain;

import racing.domain.generator.NumberGenerator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final NumberGenerator numberGenerator;
    private int distance = 0;

    public Car(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    void move() {
        move(numberGenerator.generate());
    }

    private void move(int value) {
        if (MOVE_THRESHOLD <= value) {
            this.distance++;
        }
    }

    int getDistance() {
        return this.distance;
    }

    @Override
    public String toString() {
        return IntStream.range(0, this.distance)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }
}
