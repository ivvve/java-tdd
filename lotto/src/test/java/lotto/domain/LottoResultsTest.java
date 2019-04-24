package lotto.domain;

import lotto.vo.Money;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultsTest {
    @Test
    public void 총_수익_가져오기() {
        // given
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.FIRST, LottoRank.SECOND, LottoRank.FAIL);

        // when
        LottoResults lottoResults = new LottoResults(lottoRanks);

        // then
        List<Money> winningMonies = lottoRanks.stream()
                .map(LottoRank::getWinningMoney)
                .collect(Collectors.toList());
        Money totalWinningMoney = Money.sumOf(winningMonies);

        assertThat(lottoResults.getTotalProfit()).isEqualTo(totalWinningMoney);
    }

    @Test
    public void 총_수익률_가져오기() {
        // given
        Money principal = new Money(3_000);
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.FIRST, LottoRank.SECOND, LottoRank.FAIL);

        // when
        LottoResults lottoResults = new LottoResults(lottoRanks);

        // then
        List<Money> winningMonies = lottoRanks.stream()
                .map(LottoRank::getWinningMoney)
                .collect(Collectors.toList());
        Money totalWinningMoney = Money.sumOf(winningMonies);

        assertThat(lottoResults.getTotalProfitRate(principal)).isEqualTo(totalWinningMoney.getRateCompareTo(principal));
    }
}
