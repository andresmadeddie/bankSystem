package com.solvd.entities.accounts;

import com.solvd.abstractclasses.AbstractAccount;
import com.solvd.entities.Transaction;
import com.solvd.exceptions.NotEnoughFundsException;
import com.solvd.exceptions.OverCreditLimitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Objects;

public class CheckingAccount extends AbstractAccount {
    private static final Logger LOGGER = LogManager.getLogger(CheckingAccount.class);
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
        //Check credit limit
        try {
            if (amount > overdraftLimit + getBalance()) {
                throw new NotEnoughFundsException("\nInsufficient funds. Withdrawal amount exceeds overdraft limit.");
            } else {
                Transaction transaction = new Transaction(LocalDateTime.now(), Math.random() * 100);
                setBalance(getBalance() + amount);
                System.out.println("\nSuccessful transaction. \nCurrent Balance: " + getBalance());
            }
        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
            LOGGER.info(e.getMessage());
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
