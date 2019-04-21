package racing.parser;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameParserTest {
    @Test
    public void 자동차_이름_문자열을_문자열_리스트로_변환() {
        // given
        String source = "pobi, crong, honux";

        // when
        CarNameParser parser = new CarNameParser(",");

        // then
        assertThat(parser.parse(source))
                .hasSize(3)
                .containsExactly("pobi", "crong", "honux");
    }
}
