package racing.domain.generator;

import racing.domain.generator.NumberGenerator;

public class CarMoveThresholdGenerator implements NumberGenerator {
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public int generate() {
        return MOVE_THRESHOLD;
    }
}
