package lotto.console;

import java.util.Scanner;

public class ConsoleInputView {
    private ConsoleInputView() {
    }

    public static long inputMoney(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(scanner.nextLine());
    }

    public static String inputWinningLotto(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
