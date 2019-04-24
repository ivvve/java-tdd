package lotto.domain;

import lotto.vo.Money;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoResults {
    private final Map<LottoRank, Long> lottoRanks;

    public LottoResults(List<LottoRank> lottoRanks) {
        this.lottoRanks = new EnumMap<>(LottoRank.class);

        for (LottoRank lottoRank : lottoRanks) {
            long winningCount = getWinningCountOf(lottoRank);
            this.lottoRanks.put(lottoRank, winningCount + 1);
        }
    }

    public long getWinningCountOf(LottoRank lottoRank) {
        return Optional.ofNullable(this.lottoRanks.get(lottoRank))
                .orElse(0L);
    }

    public double getTotalProfitRate(Money totalMoney) {
        return getTotalProfit().getRateCompareTo(totalMoney);
    }

    Money getTotalProfit() {
        List<Money> totalProfit = this.lottoRanks.keySet().stream()
                .map(lottoRank -> {
                    long winningCountOf = getWinningCountOf(lottoRank);
                    return lottoRank.getProfit(winningCountOf);
                })
                .collect(Collectors.toList());

        return Money.sumOf(totalProfit);
    }
}
