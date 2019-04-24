package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
}
