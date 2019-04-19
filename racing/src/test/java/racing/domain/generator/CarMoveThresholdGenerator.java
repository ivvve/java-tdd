package racing.domain.generator;

public class CarMoveThresholdGenerator implements NumberGenerator {
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public int generate() {
        return MOVE_THRESHOLD;
    }
}
