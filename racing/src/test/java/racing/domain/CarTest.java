package racing.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final int MOVE_THRESHOLD = 4;

    @Test
    public void Car_이동_문턱값_이상() {
        // given
        Car car = new Car();

        // when
        car.move(MOVE_THRESHOLD);

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    public void Car_이동_문턱값_미만() {
        // given
        Car car = new Car();

        // when
        car.move(MOVE_THRESHOLD - 1);

        // then
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
