package racing.domain;

import org.junit.Test;
import racing.domain.generator.CarMoveThresholdGenerator;
import racing.domain.generator.NumberGenerator;
import racing.domain.generator.ZeroGenerator;
import racing.vo.Distance;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private NumberGenerator carMoveThresholdGenerator = new CarMoveThresholdGenerator();
    private NumberGenerator zeroGenerator = new ZeroGenerator();

    @Test
    public void 이동() {
        // given
        Car car1 = moveCar();
        Car car2 = moveCar();

        Cars cars = new Cars(Arrays.asList(car1, car2));

        // when
        cars.moveAllCar();

        // then
        List<Car> allCars = cars.getCars();

        allCars.forEach(car ->
                assertThat(car.getDistance()).isEqualTo(new Distance(1)));
    }

    @Test
    public void 최고_이동거리_가져오기() {
        // given
        Car winner1 = moveCar();
        Car winner2 = moveCar();
        Car loser = dontMoveCar();

        Cars cars = new Cars(Arrays.asList(winner1, winner2, loser));

        // when
        cars.moveAllCar();

        // then
        assertThat(cars.getMaxDistance()).isEqualTo(1);
    }

    @Test
    public void 승자_가져오기() {
        // given
        Car winner1 = moveCar();
        Car winner2 = moveCar();
        Car loser = dontMoveCar();

        Cars cars = new Cars(Arrays.asList(winner1, winner2, loser));

        // when
        cars.moveAllCar();

        // then
        List<Car> winners = cars.getWinners();
        assertThat(winners).containsExactly(winner1, winner2);
    }

    private Car moveCar() {
        return new Car("son", carMoveThresholdGenerator);
    }

    private Car dontMoveCar() {
        return new Car("son", zeroGenerator);
    }
}
