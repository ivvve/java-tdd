package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {
    @Test
    public void LottoNumber가_6개_있어야함() {
        // given
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 5)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }

    @Test
    public void 해당_로또숫자의_포함여부_확인() {
        // given
        LottoNumber target = LottoNumber.of(1);

        LottoNumbers contains = getLottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumbers notContains = getLottoNumbers(11, 12, 13, 14, 15, 16);

        // when
        boolean shouldBeTrue = contains.contains(target);
        boolean shouldBeFalse = notContains.contains(target);

        // then
        assertThat(shouldBeTrue).isTrue();
        assertThat(shouldBeFalse).isFalse();
    }

    @Test
    public void 서로_중복되는_로또숫자의_갯수_확인() {
        // given
        LottoNumbers lottoNumbers = getLottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumbers target = getLottoNumbers(1, 2, 3, 14, 15, 16);

        // when
        int numberOfDuplicatedLottoNumbers = lottoNumbers.getNumberOfDuplicatedLottoNumbers(target);

        // then
        assertThat(numberOfDuplicatedLottoNumbers).isEqualTo(3);
    }

    private LottoNumbers getLottoNumbers(int... lottoNumber) {
        List<LottoNumber> lottoNumbers = Arrays.stream(lottoNumber)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }
}
