package racing.domain;

import org.junit.Test;
import racing.domain.generator.CarMoveThresholdGenerator;
import racing.domain.generator.NumberGenerator;
import racing.domain.generator.ZeroGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    @Test
    public void Car_이동_문턱값_이상() {
        // given
        NumberGenerator numberGenerator = new CarMoveThresholdGenerator();
        Car car = new Car(numberGenerator);

        // when
        car.move();

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    public void Car_이동_문턱값_미만() {
        // given
        NumberGenerator numberGenerator = new ZeroGenerator();
        Car car = new Car(numberGenerator);

        // when
        car.move();

        // then
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    public void toString_이동한거리를_표시() {
        // given
        NumberGenerator numberGenerator = new CarMoveThresholdGenerator();
        Car car = new Car(numberGenerator);

        // when
        car.move();
        car.move();

        // then
        assertThat(car.toString()).isEqualTo("--");
    }
}
