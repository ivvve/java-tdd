package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    public void 로또숫자는_1이상() {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(0));
    }

    @Test
    public void 로또숫자는_45이하() {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(46));
    }

    @Test
    public void LottoNumber_caching_테스트() {
        // when
        // then
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
    }
}
