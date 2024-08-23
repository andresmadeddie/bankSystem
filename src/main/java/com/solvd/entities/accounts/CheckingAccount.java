package main.java.com.solvd.entities.accounts;

import main.java.com.solvd.abstractclasses.AbstractAccount;
import main.java.com.solvd.entities.Transaction;

import java.time.LocalDateTime;
import java.util.Objects;

public class CheckingAccount extends AbstractAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        Transaction transaction = new Transaction(LocalDateTime.now(), amount);
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() + overdraftLimit < amount) {
            System.out.println("Insufficient funds. Withdrawal amount exceeds overdraft limit.");
            return;
        }

        Transaction transaction = new Transaction(LocalDateTime.now(), Math.random() * 100);
        setBalance(getBalance() - amount);

        if (getBalance() < amount) {
            System.out.println("Transaction successful. Overdraft occurred.");
        } else {
            System.out.println("Transaction successful.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", overdraftLimit=" + overdraftLimit;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        CheckingAccount that = (CheckingAccount) obj;
        return Double.compare(that.overdraftLimit, overdraftLimit) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), overdraftLimit);
    }
}
