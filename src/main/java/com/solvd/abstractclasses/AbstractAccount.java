package com.solvd.abstractclasses;

import com.solvd.entities.Branch;

public abstract class AbstractAccount {
    private final String accountNumber;
    private double balance;

    public AbstractAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void deposit(double amount, Branch branch);

    public abstract void withdraw(double amount, Branch branch);

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance, Branch branch) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return accountNumber + ", balance=" + balance;
    }
}