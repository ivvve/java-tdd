package lotto;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    public void winNumbers_모두_unique한_값인지_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        int[] winNumbers = lottoMachine.winNumbers();

        long countOfUniqueWinNumbers = Arrays.stream(winNumbers)
                .distinct()
                .count();

        assertThat(countOfUniqueWinNumbers).isEqualTo(winNumbers.length);
    }
}