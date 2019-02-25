package account;

public class Account {
    private int balance;

    public Account(int money) {
        this.balance = money;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int moeny) {
        this.balance += moeny;
    }

    public void withdraw(int money) {
        if (this.balance - money < 0) {
            throw new IllegalStateException("금액이 마이너스가 될 수 없습니다.");
        }

        this.balance -= money;
    }
}
