package racing.domain.generator;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.RacingGame;
import racing.vo.Round;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameGenerator {
    private final NumberGenerator numberGenerator;

    public RacingGameGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public RacingGame generate(int numberOfCar, Round totalRound) {
        return new RacingGame(makeCars(numberOfCar), totalRound);
    }

    private Cars makeCars(int numberOfCar) {
        List<Car> allCars = IntStream.range(0, numberOfCar)
                .mapToObj(i -> new Car(this.numberGenerator))
                .collect(Collectors.toList());

        return new Cars(allCars);
    }
}
