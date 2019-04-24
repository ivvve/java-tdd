package lotto.vo;

import java.util.List;
import java.util.Objects;

public class Money {
    private static final long MIN_MONEY = 0L;

    private final long money;

    public Money(long money) {
        validateMoney(money);

        this.money = money;
    }

    public static Money sumOf(List<Money> monies) {
        long totalMoney = monies.stream()
                .mapToLong(money -> money.money)
                .sum();

        return new Money(totalMoney);
    }

    public Money multiply(long count) {
        return new Money(this.money * count);
    }

    public double getRateCompareTo(Money principal) {
        return (double) this.money / principal.money;
    }

    public long getQuantityOf(Money price) {
        return (this.money / price.money);
    }

    public boolean isLowerThan(Money target) {
        return this.money < target.money;
    }

    private void validateMoney(long money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException("Money must be at least " + MIN_MONEY);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
