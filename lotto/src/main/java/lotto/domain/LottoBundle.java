package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {
    private final List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public long getNumberOfLottos() {
        return this.lottos.size();
    }

    @Override
    public String toString() {
        return this.lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }
}
