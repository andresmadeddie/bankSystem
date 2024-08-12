package bankclasses.Accounts;

import bankclasses.Transaction;

import java.time.LocalDateTime;
import java.util.Objects;

public class CreditCardAccount extends Account {
    private double creditLimit;
    private double outstandingBalance;

    public CreditCardAccount(String accountNumber, double balance, double creditLimit, double outstandingBalance) {
        super(accountNumber, balance);
        this.creditLimit = creditLimit;
        this.outstandingBalance = outstandingBalance;
    }

    @Override
    public void deposit(double amount) {
        Transaction transaction = new Transaction(LocalDateTime.now(), amount);
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        Transaction transaction = new Transaction(LocalDateTime.now(), Math.random() * 100);
        setBalance(getBalance() - amount);
    }

    @Override
    public String toString() {
        return super.toString() + ", creditLimit=" + creditLimit + ", outstandingBalance=" + outstandingBalance;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        CreditCardAccount that = (CreditCardAccount) obj;
        return Double.compare(that.creditLimit, creditLimit) == 0 &&
                Double.compare(that.outstandingBalance, outstandingBalance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creditLimit, outstandingBalance);
    }
}
