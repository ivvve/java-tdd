package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    void moveAllCar() {
        this.cars.forEach(Car::move);
    }

    List<Car> getWinners() {
        int maxDistance = getMaxDistance();

        return this.cars.stream()
                .filter(car -> (maxDistance == car.getDistance()))
                .collect(Collectors.toList());
    }

    int getMaxDistance() {
        return this.cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();
    }
}
