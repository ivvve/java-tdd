package account;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class AccountTest {
    private Account account;

    @Before
    public void init() {
        this.account = new Account(10_000);
    }

    @Test
    public void testAccount() {
    }

    @Test
    public void test_잔액_확인() {
        assertThat(this.account.getBalance(), is(10_000));
    }

    @Test
    public void test_입금() {
        int money = 10_000;

        this.account.deposit(1_000);
        money += 1_000;
        assertThat(this.account.getBalance(), is(money));

        this.account.deposit(100);
        money += 100;
        assertThat(this.account.getBalance(), is(money));

        this.account.deposit(100_000);
        money += 100_000;
        assertThat(this.account.getBalance(), is(money));

        this.account.deposit(2_303);
        money += 2_303;
        assertThat(this.account.getBalance(), is(money));
    }

    @Test
    public void test_출금() {
        int money = 10_000;

        this.account.withdraw(1_000);
        money -= 1_000;
        assertThat(this.account.getBalance(), is(money));

        this.account.withdraw(147);
        money -= 147;
        assertThat(this.account.getBalance(), is(money));

        this.account.withdraw(325);
        money -= 325;
        assertThat(this.account.getBalance(), is(money));
    }

    @Test(expected = IllegalStateException.class)
    public void test_마이너스_출금() {
        int money = 10_000;

        this.account.withdraw(100_000);
    }
}