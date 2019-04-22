package lotto.domain;

import lotto.vo.Money;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    public void 입력_금액에서_구매_로또_갯수_구하기() {
        // given
        int amount = 13_430;
        Money money = new Money(amount);

        // when
        int numberOfLotto = LottoMachine.getNumberOfLottoFromMoney(money);

        // then
        assertThat(numberOfLotto).isEqualTo(amount / 1_000);
    }


    @Test
    public void 입력_금액에서_구매_로또_가져오기() {
        // given
        int amount = 13_430;
        Money money = new Money(amount);

        // when
        LottoBundle lottoBundle = LottoMachine.getLottoBundle(money);

        // then
        assertThat(lottoBundle.getLottos()).hasSize(amount / 1_000);
    }
}
