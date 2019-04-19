package racing.vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class RoundTest {

    @Test
    public void 게임_라운드는_0_미만일_경우_IllegalArgumentException() {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Round(-1));
    }

    @Test
    public void 다음_라운드_가져오기() {
        // given
        Round firstRound = new Round(1);

        // when
        Round secondRound = firstRound.nextRound();

        // then
        assertThat(secondRound.equalTo(2)).isTrue();
    }

    @Test
    public void equals_테스트() {
        // given
        Round round = new Round(1);
        Round sameRound = new Round(1);

        // when
        boolean shouldBeTrue = round.equals(sameRound);

        // then
        assertThat(shouldBeTrue).isTrue();
    }
}
