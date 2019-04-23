package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {
    @Test
    public void LottoBundle에서_당첨_순위_가져오기() {
        // given
        Lotto winningLotto = getLotto(1, 2, 3, 4, 5, 6);

        Lotto first = getLotto(1, 2, 3, 4, 5, 6);
        Lotto second = getLotto(1, 2, 3, 4, 5, 16);
        Lotto third = getLotto(1, 2, 3, 4, 15, 16);
        List<Lotto> lottos = Arrays.asList(first, second, third);
        LottoBundle lottoBundle = new LottoBundle(lottos);

        // when
        List<LottoRank> lottoRanks = lottoBundle.getLottoRanks(winningLotto);

        // then
        assertThat(lottoRanks)
                .containsExactly(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD);
    }

    @Test
    public void LottoBundle에서_LottoResults_가져오기() {
        // given
        Lotto winningLotto = getLotto(1, 2, 3, 4, 5, 6);

        Lotto first = getLotto(1, 2, 3, 4, 5, 6);
        Lotto second = getLotto(1, 2, 3, 4, 5, 16);
        Lotto third = getLotto(1, 2, 3, 4, 15, 16);
        List<Lotto> lottos = Arrays.asList(first, second, third);
        LottoBundle lottoBundle = new LottoBundle(lottos);

        // when
        LottoResults lottoResults = lottoBundle.getLottoResults(winningLotto);

        // then
        assertThat(lottoResults.getWinningCountOf(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResults.getWinningCountOf(LottoRank.SECOND)).isEqualTo(1);
        assertThat(lottoResults.getWinningCountOf(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoResults.getWinningCountOf(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(lottoResults.getWinningCountOf(LottoRank.FAIL)).isEqualTo(0);
    }

    private Lotto getLotto(int... numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());

        return new Lotto(new LottoNumbers(lottoNumbers));
    }
}
