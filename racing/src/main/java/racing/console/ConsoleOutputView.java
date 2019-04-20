package racing.console;

import racing.domain.RacingGame;

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
}
