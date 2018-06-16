public class USDollarAccount extends AbstractBankAccount {

    static final float EXCHANGE_RATE = 0.75f;

    public float getBalance() {
        return balance;
    }

    public void credit(float amount) {
        balance += amount * EXCHANGE_RATE;
    }

    public void debit(float amount) {
        balance -= amount * EXCHANGE_RATE;
    }
}