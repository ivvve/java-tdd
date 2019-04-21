package racing.domain;

import org.junit.Test;
import racing.domain.generator.CarMoveThresholdGenerator;
import racing.domain.generator.NumberGenerator;
import racing.domain.generator.ZeroGenerator;
import racing.vo.Distance;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void Car_이동_문턱값_이상() {
        // given
        String name = "son";
        NumberGenerator numberGenerator = new CarMoveThresholdGenerator();
        Car car = new Car(name, numberGenerator);

        // when
        car.move();

        // then
        assertThat(car.getDistance()).isEqualTo(new Distance(1));
    }

    @Test
    public void Car_이동_문턱값_미만() {
        // given
        String name = "son";
        NumberGenerator numberGenerator = new ZeroGenerator();
        Car car = new Car(name, numberGenerator);

        // when
        car.move();

        // then
        assertThat(car.getDistance()).isEqualTo(new Distance(0));
    }

    @Test
    public void toString_이름과_이동한거리를_표시() {
        // given
        String name = "son";
        NumberGenerator numberGenerator = new CarMoveThresholdGenerator();
        Car car = new Car(name, numberGenerator);

        // when
        car.move();
        car.move();

        // then
        assertThat(car.toString()).isEqualTo(name + " : --");
    }
}
