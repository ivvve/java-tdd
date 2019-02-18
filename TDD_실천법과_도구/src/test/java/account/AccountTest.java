package account;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    private Account account;

    @Before
    public void setup() {
        this.account = new Account(10_000);
    }

    @Test
    public void testAccount() {
    }


    @Test
    public void testGetBalance() {
        assertEquals(10_000, account.getBalance());

        account = new Account(1_000);
        assertEquals(1_000, account.getBalance());

        account = new Account(0);
        assertEquals(0, account.getBalance());

        account = new Account(3_000);
        assertEquals(3_000, account.getBalance());
    }

    @Test
    public void testDeposit() {
        account.deposit(1_000);
        assertEquals(11_000, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(1_000);
        assertEquals(9_000, account.getBalance());
    }
}
