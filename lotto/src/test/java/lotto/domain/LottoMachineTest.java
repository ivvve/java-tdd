package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.OrderedLottoGenerator;
import lotto.vo.Money;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
        LottoBundle lottoBundle = lottoMachine.buyLotto(money);

        // then
        assertThat(lottoBundle.getLottos()).hasSize(amount / 1_000);
    }

    @Test
    public void 구매_불가한_금액을_넣을때_IllegalArgumentException() {
        // given
        LottoGenerator lottoGenerator = new OrderedLottoGenerator();
        LottoMachine lottoMachine = new LottoMachine(lottoGenerator);

        int amount = 500;
        Money money = new Money(amount);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> lottoMachine.buyLotto(money));
    }

}
