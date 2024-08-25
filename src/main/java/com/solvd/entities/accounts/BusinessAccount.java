package com.solvd.entities.accounts;

import com.solvd.abstractclasses.AbstractAccount;
import com.solvd.entities.Transaction;

import java.time.LocalDateTime;
import java.util.Objects;

public class BusinessAccount extends AbstractAccount {
    private String businessName;
    private String businessTaxId;

    public BusinessAccount(String accountNumber, double balance, String businessName, String businessTaxId) {
        super(accountNumber, balance);
        this.businessName = businessName;
        this.businessTaxId = businessTaxId;
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
        return super.toString() + ", businessName=" + businessName + ", businessTaxId=" + businessTaxId;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        BusinessAccount that = (BusinessAccount) obj;
        return businessName.equals(that.businessName) && businessTaxId.equals(that.businessTaxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), businessName, businessTaxId);
    }
}
