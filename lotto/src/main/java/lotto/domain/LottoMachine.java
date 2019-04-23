package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.vo.Money;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoMachine {
    private static final Money LOTTO_PRICE = new Money(1_000L);

    private final LottoGenerator lottoGenerator;

    public LottoMachine(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public LottoBundle getLottoBundle(Money money) {
        long numberOfLottos = getNumberOfLottoFromMoney(money);

        List<Lotto> lottos = LongStream.range(0, numberOfLottos)
                .mapToObj(i -> this.lottoGenerator.generate())
                .collect(Collectors.toList());

        return new LottoBundle(lottos);
    }

    long getNumberOfLottoFromMoney(Money money) {
        return money.getQuantityOf(LOTTO_PRICE);
    }
}
