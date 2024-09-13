package com.solvd.abstractclasses;

public abstract class AbstractAccount {
    private final String accountNumber;
    private double balance;

    public AbstractAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return accountNumber + ", balance=" + balance;
    }
}