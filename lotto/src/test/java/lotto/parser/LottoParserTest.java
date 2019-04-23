package lotto.parser;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoParserTest {
    private static final Logger log = LoggerFactory.getLogger(LottoParserTest.class);

    @Test
    public void 정상_parsing_테스트() {
        // given
        String source = "1, 2, 3, 4, 5, 6";

        // when
        Lotto lotto = LottoParser.parseLotto(source);

        // then
        log.debug("generated lotto : {}", lotto);
     }

    @Test
    public void 올바르지_않은_값에_대해서_IllegalArgumentException() {
        // given
        String source = "1, 2, 3, 4, 5, 116";

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> LottoParser.parseLotto(source));
    }


}
