package lotto.vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {

    @Test
    public void 돈은_0원_이상() {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-1L));
    }

    @Test
    public void 물건_구매_가능_갯수_구하기() {
        // given
        Money money = new Money(10_340L);
        Money price = new Money(1_000L);

        // when
        long quantity = money.getQuantityOf(price);

        // then
        assertThat(quantity).isEqualTo(money.getValue() / price.getValue());
    }
}
