package lotto.domain;

import java.util.List;

public class LottoNumbers {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);

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

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("Lotto numbers size must be " + LOTTO_NUMBERS_SIZE);
        }
    }

}
