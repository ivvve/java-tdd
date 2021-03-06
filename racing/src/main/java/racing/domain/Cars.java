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
                .filter(car -> (maxDistance == car.getDistanceValue()))
                .collect(Collectors.toList());
    }

    int getMaxDistance() {
        return this.cars.stream()
                .mapToInt(Car::getDistanceValue)
                .max()
                .getAsInt();
    }

    @Override
    public String toString() {
        return this.cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
