package bankclasses.Accounts;

import bankclasses.Transaction;

import java.time.LocalDateTime;
import java.util.Objects;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
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
        return super.toString() + ", interestRate=" + interestRate;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        SavingsAccount that = (SavingsAccount) obj;
        return Double.compare(that.interestRate, interestRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), interestRate);
    }
}
