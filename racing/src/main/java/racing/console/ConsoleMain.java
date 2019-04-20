package racing.console;

import racing.domain.RacingGame;
import racing.domain.generator.RacingGameGenerator;
import racing.domain.generator.RandomPositiveNumberUnderTenGenerator;
import racing.vo.Round;

import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        int numberOfCar;
        int numberOfRound;

        try (Scanner scanner = new Scanner(System.in)) {
            numberOfCar = ConsoleInputView.inputNumberOfCar(scanner);
            numberOfRound = ConsoleInputView.inputNumberOfRound(scanner);
        }

        RacingGame racingGame = generateRacingGame(numberOfCar, numberOfRound);

        ConsoleOutputView.printEmpryLine();
        ConsoleOutputView.printMessage("실행 결과");

        while (racingGame.hasNextRound()) {
            racingGame.nextRound();
            ConsoleOutputView.printRacingGmae(racingGame);
            ConsoleOutputView.printEmpryLine();
        }
    }

    private static RacingGame generateRacingGame(int numberOfCar, int numberOfRound) {
        RacingGameGenerator racingGameGenerator =
                new RacingGameGenerator(new RandomPositiveNumberUnderTenGenerator());

        return racingGameGenerator.generate(numberOfCar, new Round(numberOfRound));
    }

}
