package lotto.domain;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    LottoRank getRank(Lotto target) {
        int numberOfDuplicatedLottoNumbers = this.lottoNumbers.getNumberOfDuplicatedLottoNumbers(target.lottoNumbers);
        return LottoRank.of(numberOfDuplicatedLottoNumbers);
    }
}
