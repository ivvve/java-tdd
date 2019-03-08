package lotto;

import java.util.*;

public class LottoMachine {
    private final int minLottoNumber = 1;
    private final int maxLottoNumber = 45;
    private final int numberOfWinNumbers = 6;


    public LottoNumber lottoNumber() {
        List<Integer> shuffledAllLottoNumbers = this.getShuffledAllLottoNumbers();
        List<Integer> winNumbers = new ArrayList<>(numberOfWinNumbers);
        int bonusNumber;

        for (int i = 0; i < numberOfWinNumbers; i++) {
            int winNumber = shuffledAllLottoNumbers.get(i);
            winNumbers.add(winNumber);
        }

        bonusNumber = shuffledAllLottoNumbers.get(numberOfWinNumbers);

        return new LottoNumber(winNumbers, bonusNumber);
    }

    private List<Integer> getShuffledAllLottoNumbers() {
        List<Integer> allLottoNumbers = this.getAllLottoNumbers();
        return shuffleLottoNumbers(allLottoNumbers);
    }

    private List<Integer> getAllLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(maxLottoNumber);

        for (int i = 1; i <= maxLottoNumber; i++) {
            lottoNumbers.add(i);
        }

        return lottoNumbers;
    }

    private List<Integer> shuffleLottoNumbers(List<Integer> lottoNumbers) {
        for (int i = 0; i < 10; i++) {
            Collections.shuffle(lottoNumbers);
        }

        return lottoNumbers;
    }
}
