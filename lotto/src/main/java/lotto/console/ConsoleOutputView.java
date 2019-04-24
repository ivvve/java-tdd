package lotto.console;

import lotto.domain.LottoBundle;
import lotto.domain.LottoRank;
import lotto.domain.LottoResults;
import lotto.vo.Money;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConsoleOutputView {
    private ConsoleOutputView() {
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printPurchasedLotto(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.getNumberOfLottos() + "개를 구매했습니다.");

        System.out.println(lottoBundle);
    }

    public static void printResults(LottoResults lottoResults) {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.values());
        Collections.reverse(lottoRanks);

        System.out.println("당첨 통계");
        System.out.println("---------");

        lottoRanks.stream()
                .filter(LottoRank::notFail)
                .forEach(lottoRank -> {
                    long winningCount = lottoResults.getWinningCountOf(lottoRank);
                    System.out.printf("%d개 일치 (%s원)- %d개%n",
                            winningCount, lottoRank.getWinningMoney(), lottoRank.getDuplicatedNumber());
                });
    }

    public static void printTotalProfitRate(LottoResults lottoResults, Money totalMoney) {
        System.out.printf("총 수익률은 %.2f입니다.", lottoResults.getTotalProfitRate(totalMoney));
    }

}
