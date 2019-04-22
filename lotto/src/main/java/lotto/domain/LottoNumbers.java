package lotto.domain;

import java.util.List;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    int getNumberOfDuplicatedLottoNumbers(LottoNumbers target) {
        return (int) target.lottoNumbers.stream()
                .filter(this::contains)
                .count();
    }

    boolean contains(LottoNumber target) {
        return this.lottoNumbers.contains(target);
    }
}
