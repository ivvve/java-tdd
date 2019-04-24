package lotto.console;

import lotto.domain.*;
import lotto.domain.generator.RandomLottoGenerator;
import lotto.parser.LottoParser;
import lotto.vo.Money;

import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Money money = inputMoney(scanner);
            LottoMachine lottoMachine = new LottoMachine(new RandomLottoGenerator());

            LottoBundle lottoBundle = lottoMachine.buyLotto(money);
            ConsoleOutputView.printPurchasedLotto(lottoBundle);

            Lotto winningLotto = inputWinningLotto(scanner);
            ConsoleOutputView.printEmptyLine();

            LottoResults lottoResults = lottoBundle.getLottoResults(winningLotto);
            ConsoleOutputView.printEmptyLine();

            ConsoleOutputView.printResults(lottoResults, money);
        }
    }

    private static Money inputMoney(Scanner scanner) {
        long money = ConsoleInputView.inputMoney(scanner);
        return new Money(money);
    }

    private static Lotto inputWinningLotto(Scanner scanner) {
        String winningLotto = ConsoleInputView.inputWinningLotto(scanner);
        return LottoParser.parseLotto(winningLotto);
    }
}
