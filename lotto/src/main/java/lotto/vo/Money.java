package lotto.vo;

public class Money {
    private static final long MIN_MONEY = 0L;

    private final long money;

    public Money(long money) {
        validateMoney(money);

        this.money = money;
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
}
