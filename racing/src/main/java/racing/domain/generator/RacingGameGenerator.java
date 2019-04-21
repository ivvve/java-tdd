package racing.domain.generator;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.RacingGame;
import racing.vo.Round;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameGenerator {
    private final NumberGenerator numberGenerator;

    public RacingGameGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public RacingGame generate(List<String> carNames, Round totalRound) {
        return new RacingGame(makeCars(carNames), totalRound);
    }

    private Cars makeCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(carName -> new Car(carName, this.numberGenerator))
                .collect(Collectors.toList());

        return new Cars(cars);
    }
}
