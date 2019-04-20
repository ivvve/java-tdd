package racing.vo;

import java.util.Objects;

public class Round {
    private static final int MIN_ROUND = 0;
    private final int round;

    public Round(int round) {
        validateRound(round);

        this.round = round;
    }

    public Round nextRound() {
        return new Round(this.round + 1);
    }

    public boolean equalTo(int target) {
        return (this.round == target);
    }

    public int getValue() {
        return this.round;
    }

    public boolean isLowerThan(Round target) {
        return this.round < target.round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }

    private void validateRound(int round) {
        if (round < MIN_ROUND) {
            throw new IllegalArgumentException("Round should be at least " + MIN_ROUND);
        }
    }
}
