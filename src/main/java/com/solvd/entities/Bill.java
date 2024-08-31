package com.solvd.entities;

public class Bill {
    private String serialNumber;
    private int denomination;

    public Bill(String serialNumber, int denomination) {
        this.serialNumber = serialNumber;
        this.denomination = denomination;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getDenomination() {
        return denomination;
    }

    @Override
    public String toString() {
        return "Bill{serialNumber='" + serialNumber + "', denomination=" + denomination + '}';
    }
}