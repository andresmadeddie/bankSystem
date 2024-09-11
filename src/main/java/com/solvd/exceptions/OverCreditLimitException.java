package com.solvd.exceptions;

public class OverCreditLimitException extends Exception {
    public OverCreditLimitException(String message) {
        super(message);
    }
}
