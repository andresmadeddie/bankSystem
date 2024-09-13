package com.solvd.entities;

import com.solvd.entities.people.Customer;
import com.solvd.entities.people.Person;
import com.solvd.utils.MyLinkedList;

import java.util.*;

public final class Branch {
    static final String bankName;

    static {
        bankName = "BankMine";
    }

    public String getBranchId() {
        return branchId;
    }

    private String branchId;
    private String branchName;
    private String address;
    private String city;
    private final MyLinkedList<Person> payroll;
    private final Set<Customer> customerDB;
    private List<Transaction> transactionDB;

    public Branch(String branchId, String branchName, String address, String city) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.address = address;
        this.city = city;
        this.payroll = new MyLinkedList<>();
        this.customerDB = new HashSet<>();
        this.transactionDB = new ArrayList<>();
        Bank.addBranchToBranches(city,this);
    }

    public final String getBankName() {
        return bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    // TRANSACTION METHODS
    public List<Transaction> getTransactionDB() {
        return transactionDB;
    }

    public void addToTransactionDB (Transaction transaction) {
        transactionDB.add(transaction);
    }

    // CUSTOMER LIST METHODS
    public Set<Customer> getCustomerDB() {
        return customerDB;
    }

    public void addCustomerDB(Customer customer) {
        if (!customerDB.contains(customer)) {
            customerDB.add(customer);
        } else {
            System.out.println("Customer already in the Database");
        }
    }


    // PAYROLL METHODS
    public void addPersonTOPayroll(Person newPerson) {
        if (!payroll.search(newPerson)) {
            payroll.add(newPerson);
        } else {
            System.out.println("This person already exists on the payroll");
        }
    }

    public MyLinkedList<Person> getPayroll() {
        return payroll;
    }

    public void printPayroll(){
        payroll.showAll();
    }

    @Override
    public String toString() {
        return "branchId=" + branchId + ", branchName=" + branchName + ", address=" + address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Branch branch = (Branch) obj;
        return branchId.equals(branch.branchId) && branchName.equals(branch.branchName) && address.equals(branch.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, branchName, address);
    }
}
