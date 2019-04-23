package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.Collections;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 6;

    @Override
    public Lotto generate() {
        List<LottoNumber> lottoNumbers = getShuffledLottoNumbers();
        Collections.sort(lottoNumbers);

        return new Lotto(new LottoNumbers(lottoNumbers));
    }

    private List<LottoNumber> getShuffledLottoNumbers() {
        List<LottoNumber> allLottoNumbers = LottoNumber.getAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);
        return allLottoNumbers.subList(FIRST_INDEX, LAST_INDEX);
    }
}
