package lotto;

import java.util.List;

public class LottoNumber {
    private List<Integer> winNumbers;
    private int bonusNumber;

    public LottoNumber(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> winNumbers() {
        return this.winNumbers;
    }

    public int bonusNumber() {
        return this.bonusNumber;
    }
}
