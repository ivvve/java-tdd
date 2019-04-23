package lotto.parser;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoParser {
    private LottoParser() {
    }

    public static Lotto parseLotto(String source) {
        List<LottoNumber> collect = Arrays.stream(source.split(","))
                .map(number -> toLottoNumber(number.trim()))
                .collect(Collectors.toList());

        return new Lotto(new LottoNumbers(collect));
    }

    private static LottoNumber toLottoNumber(String number) {
        int lottoNumber = Integer.parseInt(number);
        return LottoNumber.of(lottoNumber);
    }
}
