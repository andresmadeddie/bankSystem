package com.solvd.entities.accounts;

import com.solvd.abstractclasses.AbstractAccount;
import com.solvd.entities.Branch;
import com.solvd.entities.Transaction;
import com.solvd.exceptions.OverCreditLimitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Objects;

public class CreditCardAccount extends AbstractAccount {
    private static final Logger LOGGER = LogManager.getLogger(AbstractAccount.class);
    private double creditLimit;

    public CreditCardAccount(String accountNumber, double balance, double creditLimit) {
        super(accountNumber, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void deposit(double amount, Branch branch) {
        Transaction transaction = new Transaction(amount, branch);
        setBalance(getBalance() + amount, branch);
    }

    @Override
    public void withdraw(double amount, Branch branch) {
        //Check credit limit
        try {
            if (amount > creditLimit + getBalance()) {
                throw new OverCreditLimitException("\nThe requested amount exceeds your credit limit." + "\nCurrent Balance: " + getBalance() + "\nCredit Limit: " + creditLimit + "\nDifference: " + (creditLimit - getBalance()));
            } else {
                Transaction transaction = new Transaction(Math.random() * 100, branch);
                setBalance(getBalance() + amount, branch);
                System.out.println("\nSuccessful transaction. \nCurrent Balance: " + getBalance());
            }
        } catch (OverCreditLimitException e) {
            System.out.println(e.getMessage());
            LOGGER.info(e.getMessage());
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
