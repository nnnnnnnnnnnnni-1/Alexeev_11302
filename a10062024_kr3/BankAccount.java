package a10062024_kr3;

public class BankAccount {
    private volatile int balance;
    public BankAccount(int balance) {
        this.balance = balance;
    }
    public int getBalance(){
        return balance;
    }

    public void addMoney(int money) {
        synchronized (this) {
            if (money > 0) {
                balance += money;
            } else {
                throw new IllegalArgumentException("You can't add negative number of money");
            }
        }
    }
    public void subtractMoney(int money) throws NotEnoughMoneyException {
        synchronized (this) {
            if (balance >= money) {
                balance -= money;
            } else {
                throw new NotEnoughMoneyException("insufficient funds in the account");
            }
        }
    }

}

