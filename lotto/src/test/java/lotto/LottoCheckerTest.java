package lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCheckerTest {

    @Test
    public void 일등_테스트() {
        LottoChecker lottoChecker = new LottoChecker();

        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoNumber lottoNumber = new LottoNumber(winNumbers, bonusNumber);
        LottoNumber userNumber = lottoNumber;

        int ranking = lottoChecker.getRanking(userNumber, lottoNumber);

        assertThat(ranking).isEqualTo(1);
    }

    @Test
    public void 이등_테스트() {
        LottoChecker lottoChecker = new LottoChecker();

        List<Integer> winNumbers     = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userWinNumbers = Arrays.asList(1, 2, 3, 4, 5, 11);
        int bonusNumber = 7;

        LottoNumber lottoNumber = new LottoNumber(winNumbers, bonusNumber);
        LottoNumber userNumber = new LottoNumber(userWinNumbers, bonusNumber);

        int ranking = lottoChecker.getRanking(userNumber, lottoNumber);

        assertThat(ranking).isEqualTo(2);
    }


    @Test
    public void 삼등_테스트() {
        LottoChecker lottoChecker = new LottoChecker();

        List<Integer> winNumbers     = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userWinNumbers = Arrays.asList(1, 2, 3, 4, 5, 11);
        int bonusNumber = 7;
        int userBonusNumber = 10;

        LottoNumber lottoNumber = new LottoNumber(winNumbers, bonusNumber);
        LottoNumber userNumber = new LottoNumber(userWinNumbers, userBonusNumber);

        int ranking = lottoChecker.getRanking(userNumber, lottoNumber);

        assertThat(ranking).isEqualTo(3);
    }
    @Test
    public void 사등_테스트() {
        LottoChecker lottoChecker = new LottoChecker();

        List<Integer> winNumbers     = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userWinNumbers = Arrays.asList(1, 2, 3, 4, 11, 12);
        int bonusNumber = 7;
        int userBonusNumber = 10;

        LottoNumber lottoNumber = new LottoNumber(winNumbers, bonusNumber);
        LottoNumber userNumberBonusMatched = new LottoNumber(userWinNumbers, bonusNumber);
        LottoNumber userNumberNotBonusMatched = new LottoNumber(userWinNumbers, userBonusNumber);

        int ranking = lottoChecker.getRanking(userNumberBonusMatched, lottoNumber);
        assertThat(ranking).isEqualTo(4);

        ranking = lottoChecker.getRanking(userNumberNotBonusMatched, lottoNumber);
        assertThat(ranking).isEqualTo(4);
    }

    @Test
    public void 오등_테스트() {
        LottoChecker lottoChecker = new LottoChecker();

        List<Integer> winNumbers     = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userWinNumbers = Arrays.asList(1, 2, 3, 11, 12, 13);
        int bonusNumber = 7;
        int userBonusNumber = 10;

        LottoNumber lottoNumber = new LottoNumber(winNumbers, bonusNumber);
        LottoNumber userNumberBonusMatched = new LottoNumber(userWinNumbers, bonusNumber);
        LottoNumber userNumberNotBonusMatched = new LottoNumber(userWinNumbers, userBonusNumber);

        int ranking = lottoChecker.getRanking(userNumberBonusMatched, lottoNumber);
        assertThat(ranking).isEqualTo(5);

        ranking = lottoChecker.getRanking(userNumberNotBonusMatched, lottoNumber);
        assertThat(ranking).isEqualTo(5);
    }

    @Test
    public void 꽝_테스트() {
        LottoChecker lottoChecker = new LottoChecker();

        List<Integer> winNumbers     = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userWinNumbersTwoMatched = Arrays.asList(1, 2, 11, 12, 13, 14);
        List<Integer> userWinNumbersOneMatched = Arrays.asList(1, 11, 12, 13, 14, 15);
        List<Integer> userWinNumbersNotMatched = Arrays.asList(11, 12, 13, 14, 15, 16);
        int bonusNumber = 7;
        int userBonusNumber = 10;

        LottoNumber lottoNumber = new LottoNumber(winNumbers, bonusNumber);
        LottoNumber userNumberTwoMatchedBonusMatched = new LottoNumber(userWinNumbersTwoMatched, bonusNumber);
        LottoNumber userNumberTwoMatchedNotBonusMatched = new LottoNumber(userWinNumbersTwoMatched, userBonusNumber);
        LottoNumber userNumberOneMatchedBonusMatched = new LottoNumber(userWinNumbersOneMatched, bonusNumber);
        LottoNumber userNumberOneMatchedNotBonusMatched = new LottoNumber(userWinNumbersOneMatched, userBonusNumber);
        LottoNumber userNumberNotMatchedBonusMatched = new LottoNumber(userWinNumbersNotMatched, bonusNumber);
        LottoNumber userNumberNotMatchedNotBonusMatched = new LottoNumber(userWinNumbersNotMatched, userBonusNumber);

        int ranking = lottoChecker.getRanking(userNumberTwoMatchedBonusMatched, lottoNumber);
        assertThat(ranking).isEqualTo(0);

        ranking = lottoChecker.getRanking(userNumberTwoMatchedNotBonusMatched, lottoNumber);
        assertThat(ranking).isEqualTo(0);

        ranking = lottoChecker.getRanking(userNumberOneMatchedBonusMatched, lottoNumber);
        assertThat(ranking).isEqualTo(0);

        ranking = lottoChecker.getRanking(userNumberOneMatchedNotBonusMatched, lottoNumber);
        assertThat(ranking).isEqualTo(0);

        ranking = lottoChecker.getRanking(userNumberNotMatchedBonusMatched, lottoNumber);
        assertThat(ranking).isEqualTo(0);

        ranking = lottoChecker.getRanking(userNumberNotMatchedNotBonusMatched, lottoNumber);
        assertThat(ranking).isEqualTo(0);
    }

}
