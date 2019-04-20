package racing.console;

import java.util.Scanner;

public class ConsoleInputView {
    private ConsoleInputView() {
    }

    public static int inputNumberOfCar(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputNumberOfRound(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
