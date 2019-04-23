package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable {
    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    static {
        LOTTO_NUMBERS = new HashMap<>();

        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(i -> LOTTO_NUMBERS.put(i, new LottoNumber(i)));
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateNumber(number);

        return LOTTO_NUMBERS.get(number);
    }

    public static List<LottoNumber> getAllLottoNumbers() {
        return LOTTO_NUMBERS.values().stream()
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Object o) {
        return (this.number - ((LottoNumber) o).number);
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    private static void validateNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException("Lotto number must be between " + MIN_LOTTO_NUMBER + " and " + MAX_LOTTO_NUMBER);
        }
    }
}
