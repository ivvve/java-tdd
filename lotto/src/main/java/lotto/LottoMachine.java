package lotto;

import java.util.*;

public class LottoMachine {
    private final int minLottoNumber = 1;
    private final int maxLottoNumber = 45;
    private final int numberOfWinNumbers = 6;

    public int[] winNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(maxLottoNumber);

        for (int i = 1; i <= maxLottoNumber; i++) {
            lottoNumbers.add(i);
        }

        for (int i = 0; i < 10; i++) {
            Collections.shuffle(lottoNumbers);
        }

        int[] winNumbers = new int[numberOfWinNumbers];

        for (int i = 0; i < numberOfWinNumbers; i++) {
            winNumbers[i] = lottoNumbers.get(i);
        }

        return winNumbers;
    }

}
