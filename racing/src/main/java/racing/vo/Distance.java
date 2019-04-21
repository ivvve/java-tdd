package racing.vo;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Distance {
    private static final int MIN_DISTANCE = 0;

    private final int distance;

    public Distance(int distance) {
        validateDistance(distance);

        this.distance = distance;
    }

    public int getValue() {
        return this.distance;
    }

    public Distance increment() {
        return new Distance(this.distance + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    @Override
    public String toString() {
        return IntStream.range(0, this.distance)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    private void validateDistance(int distance) {
        if (distance < MIN_DISTANCE) {
            throw new IllegalArgumentException("Distance must be at least " + MIN_DISTANCE);
        }
    }
}
