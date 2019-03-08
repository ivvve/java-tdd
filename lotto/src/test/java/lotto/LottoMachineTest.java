package lotto;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    public void winNumbers_가_1과_45_사이의_값인지_테스트() {
        LottoMachine lottoMachine = new LottoMachine();

        for (int i = 0; i < 1000; i++) {
            List<Integer> winNumbers = lottoMachine.winNumbers();

            winNumbers.forEach(winNumber -> {
                assertThat(winNumber)
                        .isGreaterThanOrEqualTo(1)
                        .isLessThanOrEqualTo(45);
            });
        }
    }

    @Test
    public void winNumbers_모두_unique한_값인지_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> winNumbers = lottoMachine.winNumbers();

        System.out.println("win numbers are : " + winNumbers);

        long countOfUniqueWinNumbers = winNumbers.stream()
                .distinct()
                .count();

        assertThat(countOfUniqueWinNumbers).isEqualTo(winNumbers.size());
    }

    @Test
    public void bonusNumber_가_1과_45_사이의_값인지_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        int bonusNumber = lottoMachine.bonusNumber();

        assertThat(bonusNumber)
                .isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(45);
    }

    @Test
    public void bonusNumber_가_winNumbers_에_포함되지_않는지_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> winNumbers = lottoMachine.winNumbers();
        int bonusNumber = lottoMachine.bonusNumber();

        assertThat(winNumbers).doesNotContain(bonusNumber);
    }

}