package racing.vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DistanceTest {
    @Test
    public void 움직인_거리는_0보다_작을_경우_IllegalArgumentException() {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Distance(-1));
    }

    @Test
    public void 거리_증가() {
        // given
        Distance distance = new Distance(0);

        // when
        distance = distance.increment();

        // then
        assertThat(distance).isEqualTo(new Distance(1));
    }

    @Test
    public void 움직인거리_toString() {
        // given
        Distance distance = new Distance(0);

        // when
        distance = distance.increment();
        distance = distance.increment();

        // then
        assertThat(distance.toString()).isEqualTo("--");
    }
}
