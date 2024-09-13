package com.solvd.enums;

public enum WithdrawalMachinesNumbers {

    SN001("SN001"),
    SN002("SN002"),
    SN003("SN003");


    final String serialNumber;

    WithdrawalMachinesNumbers(String serialNumber){
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
