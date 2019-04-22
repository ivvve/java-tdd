package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 등수_구하기() {
        // given
        Lotto winner = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 16));

        // when
        LottoRank rank = winner.getRank(second);

        // then
        assertThat(rank).isEqualByComparingTo(LottoRank.SECOND);
    }

    private LottoNumbers getLottoNumbers(int... lottoNumber) {
        List<LottoNumber> lottoNumbers = Arrays.stream(lottoNumber)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }
}
