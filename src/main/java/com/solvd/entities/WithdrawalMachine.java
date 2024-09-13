package com.solvd.entities;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class WithdrawalMachine {
    private final String serialNumber;
    private final Deque<Bill> bills;
    private final Map<String, Bill> billMap; // To quickly check bills by serial number

    public WithdrawalMachine(String serialNumber) {
        bills = new ArrayDeque<>();
        billMap = new HashMap<>();
        this.serialNumber = serialNumber;
    }

    public void addBill(Bill bill) {
        bills.addFirst(bill);
        billMap.put(bill.getSerialNumber(), bill);
    }

    public Bill withdrawBill() {
        Bill bill = bills.pollFirst();
        if (bill != null) {
            billMap.remove(bill.getSerialNumber());
        }
        return bill;
    }

    public Bill checkBillBySerialNumber(String serialNumber) {
        return billMap.get(serialNumber);
    }

    public Map<String, Bill> listAllBills() {
        return billMap;
    }

}
