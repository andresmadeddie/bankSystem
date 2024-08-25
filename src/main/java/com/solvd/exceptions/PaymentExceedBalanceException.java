package com.solvd.exceptions;

public class PaymentExceedBalanceException extends Exception {
    public PaymentExceedBalanceException(String message) {
        super(message);
    }
}
