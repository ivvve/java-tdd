package lotto;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

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

}