package racing.domain;

import racing.vo.Round;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final Round totalRound;

    private Round currentRound = new Round(0);

    public RacingGame(Cars cars, Round totalRound) {
        this.cars = cars;
        this.totalRound = totalRound;
    }

    public List<Car> getWinnersOfRound() {
        return this.cars.getWinners();
    }

    boolean hasNextRound() {
        return (this.currentRound.isLowerThan(this.totalRound));
    }

    void nextRound() {
        this.cars.moveAllCar();
        this.currentRound = this.currentRound.nextRound();
    }

    Round getCurrentRound() {
        return this.currentRound;
    }
}
