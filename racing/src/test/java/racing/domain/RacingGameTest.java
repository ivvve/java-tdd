package racing.domain;

import org.junit.Test;
import racing.domain.generator.CarMoveThresholdGenerator;
import racing.domain.generator.NumberGenerator;
import racing.domain.generator.ZeroGenerator;
import racing.vo.Round;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private NumberGenerator carMoveThresholdGenerator = new CarMoveThresholdGenerator();
    private NumberGenerator zeroGenerator = new ZeroGenerator();

    @Test
    public void 라운드만큼_실행() {
        // given
        Round totalRound = new Round(5);
        Cars cars = new Cars(Arrays.asList(moveCar(), moveCar(), moveCar()));

        RacingGame racingGame = new RacingGame(cars, totalRound);

        // when
        while (racingGame.hasNextRound()) {
            racingGame.nextRound();
        }

        // then
        assertThat(racingGame.getCurrentRound()).isEqualTo(totalRound);
    }

    @Test
    public void 승자_가져오기() {
        // given
        Round totalRound = new Round(5);

        Car winner1 = moveCar();
        Car winner2 = moveCar();
        Car loser = dontMoveCar();

        Cars cars = new Cars(Arrays.asList(winner1, winner2, loser));
        RacingGame racingGame = new RacingGame(cars, totalRound);

        // when
        while (racingGame.hasNextRound()) {
            racingGame.nextRound();
        }

        // then
        List<Car> winners = racingGame.getWinners();
        assertThat(winners).containsExactly(winner1, winner2);
    }

    private Car moveCar() {
        return new Car("son", carMoveThresholdGenerator);
    }

    private Car dontMoveCar() {
        return new Car("son", zeroGenerator);
    }
}
