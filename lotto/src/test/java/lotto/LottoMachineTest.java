package lotto;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    public void winNumbers_모두_unique한_값인지_테스트() {
        LottoMachine lottoMachine = new LottoMachine();

        for (int i = 0; i < 1000; i++) {
            LottoNumber lottoNumber = lottoMachine.lottoNumber();
            List<Integer> winNumbers = lottoNumber.winNumbers();

            long countOfUniqueNumberOfWinNumbers = winNumbers.stream()
                    .distinct()
                    .count();

            assertThat(countOfUniqueNumberOfWinNumbers).isEqualTo(winNumbers.size());
        }
    }

    @Test
    public void bonusNumber_가_winNumbers_에_포함되지_않는지_테스트() {
        LottoMachine lottoMachine = new LottoMachine();

        for (int i = 0; i < 1000; i++) {
            LottoNumber lottoNumber = lottoMachine.lottoNumber();
            List<Integer> winNumbers = lottoNumber.winNumbers();
            int bonusNumber = lottoNumber.bonusNumber();

            assertThat(winNumbers).doesNotContain(bonusNumber);
        }
    }


    @Test
    public void lottoNumbers의_범위가_1과_45_사이인지_테스트() {
        LottoMachine lottoMachine = new LottoMachine();

        for (int i = 0; i < 1000; i++) {
            LottoNumber lottoNumber = lottoMachine.lottoNumber();
            List<Integer> winNumbers = lottoNumber.winNumbers();
            winNumbers.stream()
                    .forEach(n -> {
                        assertThat(this.isRightLottoNumber(n)).isEqualTo(true);
                    });

            int bonusNumber = lottoNumber.bonusNumber();
            assertThat(this.isRightLottoNumber(bonusNumber)).isEqualTo(true);
        }
    }

    private boolean isRightLottoNumber(int number) {
        return 1 <= number &&
                number <= 45;
    }
}