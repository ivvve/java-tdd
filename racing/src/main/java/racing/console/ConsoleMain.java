package racing.console;

import racing.domain.RacingGame;
import racing.domain.generator.RacingGameGenerator;
import racing.domain.generator.RandomPositiveNumberUnderTenGenerator;
import racing.parser.CarNameParser;
import racing.vo.Round;

import java.util.List;
import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        String carNames;
        int numberOfRound;

        try (Scanner scanner = new Scanner(System.in)) {
            carNames = ConsoleInputView.inputCarNames(scanner);
            numberOfRound = ConsoleInputView.inputNumberOfRound(scanner);
        }

        RacingGame racingGame = generateRacingGame(carNames, numberOfRound);

        ConsoleOutputView.printEmpryLine();
        ConsoleOutputView.printMessage("실행 결과");

        playRacingGame(racingGame);

        ConsoleOutputView.printWinners(racingGame.getWinners());
    }

    private static RacingGame generateRacingGame(String carNames, int numberOfRound) {
        List<String> cars = new CarNameParser(",").parse(carNames);

        RacingGameGenerator racingGameGenerator =
                new RacingGameGenerator(new RandomPositiveNumberUnderTenGenerator());

        return racingGameGenerator.generate(cars, new Round(numberOfRound));
    }

    private static void playRacingGame(RacingGame racingGame) {
        while (racingGame.hasNextRound()) {
            racingGame.nextRound();
            ConsoleOutputView.printRacingGmae(racingGame);
            ConsoleOutputView.printEmpryLine();
        }
    }
}
