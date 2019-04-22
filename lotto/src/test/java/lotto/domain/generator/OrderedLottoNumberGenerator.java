package lotto.domain.generator;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderedLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public LottoNumbers generate() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }
}
