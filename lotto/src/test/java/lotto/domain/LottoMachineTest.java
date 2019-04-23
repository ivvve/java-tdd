package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.OrderedLottoGenerator;
import lotto.vo.Money;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    public void 입력_금액에서_구매_로또_갯수_구하기() {
        // given
        LottoGenerator lottoGenerator = new OrderedLottoGenerator();
        LottoMachine lottoMachine = new LottoMachine(lottoGenerator);

        int amount = 13_430;
        Money money = new Money(amount);

        // when
        long numberOfLotto = lottoMachine.getNumberOfLottoFromMoney(money);

        // then
        assertThat(numberOfLotto).isEqualTo(amount / 1_000);
    }


    @Test
    public void 입력_금액에서_구매_로또_가져오기() {
        // given
        LottoGenerator lottoGenerator = new OrderedLottoGenerator();
        LottoMachine lottoMachine = new LottoMachine(lottoGenerator);

        int amount = 13_430;
        Money money = new Money(amount);

        // when
        LottoBundle lottoBundle = lottoMachine.getLottoBundle(money);

        // then
        assertThat(lottoBundle.getLottos()).hasSize(amount / 1_000);
    }
}
