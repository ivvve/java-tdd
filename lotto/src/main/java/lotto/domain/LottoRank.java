package lotto.domain;

import lotto.vo.Money;

import java.util.Arrays;

public enum LottoRank {
    FIRST(new Money(2_000_000_000), 6),
    SECOND(new Money(1_500_000), 5),
    THIRD(new Money(50_000), 4),
    FOURTH(new Money(5_000), 3),
    FAIL(new Money(0), 0);

    private final Money winningMoney;
    private final int duplicatedNumber;

    LottoRank(Money money, int duplicatedNumber) {
        winningMoney = money;
        this.duplicatedNumber = duplicatedNumber;
    }

    static LottoRank of(int duplicatedNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> (lottoRank.duplicatedNumber == duplicatedNumber))
                .findFirst()
                .orElse(LottoRank.FAIL);
    }

    Money getProfit(long count) {
        return this.winningMoney.multiply(count);
    }

    Money getWinningMoney() {
        return winningMoney;
    }

}
