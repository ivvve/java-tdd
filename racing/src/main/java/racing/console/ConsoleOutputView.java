package racing.console;

import racing.domain.Car;
import racing.domain.RacingGame;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputView {
    private ConsoleOutputView() {
    }

    public static void printEmpryLine() {
        System.out.println();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRacingGmae(RacingGame racingGame) {
        System.out.println(racingGame);
    }

    public static void printWinners(List<Car> winners) {
        String carNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(carNames + "가 최종 우승했습니다.");
    }
}
