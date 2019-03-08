package lotto;

import java.util.List;

public class LottoChecker {

    public int getRanking(LottoNumber userNumber, LottoNumber lottoNumber) {
        int winNumberMatchingCount = 0;
        boolean isBonusMatched = false;

        List<Integer> winNumbers = lottoNumber.winNumbers();
        List<Integer> userWinNumbers = userNumber.winNumbers();

        for (int i = 0, loop = winNumbers.size(); i < loop; i++) {
            int userWinNumber = userWinNumbers.get(i);

            if (winNumbers.contains(userWinNumber))
                winNumberMatchingCount++;
        }

        int bonusNumber = lottoNumber.bonusNumber();
        int userBonusNumber = userNumber.bonusNumber();
        isBonusMatched =  (bonusNumber == userBonusNumber);

        if (winNumberMatchingCount == 6)
            return 1;
        if (winNumberMatchingCount == 5 && isBonusMatched)
            return 2;
        if (winNumberMatchingCount == 5)
            return 3;
        if (winNumberMatchingCount == 4)
            return 4;
        if (winNumberMatchingCount == 3)
            return 5;

        return 0;
    }
}
