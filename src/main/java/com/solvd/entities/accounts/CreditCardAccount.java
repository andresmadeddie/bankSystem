package main.java.com.solvd.entities.accounts;

import main.java.com.solvd.abstractclasses.AbstractAccount;
import main.java.com.solvd.entities.Transaction;
import main.java.com.solvd.exceptions.OverCreditLimitException;

import java.time.LocalDateTime;
import java.util.Objects;

public class CreditCardAccount extends AbstractAccount {
    private double creditLimit;

    public CreditCardAccount(String accountNumber, double balance, double creditLimit) {
        super(accountNumber, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void deposit(double amount) {
        Transaction transaction = new Transaction(LocalDateTime.now(), amount);
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        //Check credit limit
        try {
            if (amount > creditLimit + getBalance()) {
                throw new OverCreditLimitException("\nThe requested amount exceeds your credit limit." + "\nCurrent Balance: " + getBalance() + "\nCredit Limit: " + creditLimit + "\nDifference: " + (creditLimit - getBalance()));
            } else {
                Transaction transaction = new Transaction(LocalDateTime.now(), Math.random() * 100);
                setBalance(getBalance() + amount);
                System.out.println("\nSuccessful transaction. \nCurrent Balance: " + getBalance());
            }
        } catch (OverCreditLimitException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", creditLimit=" + creditLimit;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        CreditCardAccount that = (CreditCardAccount) obj;
        return Double.compare(that.creditLimit, creditLimit) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
