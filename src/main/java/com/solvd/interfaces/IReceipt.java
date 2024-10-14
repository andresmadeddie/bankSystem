package com.solvd.interfaces;

public interface IReceipt {
    default void receipt() {
        System.out.println("\"Thank for the cash! I'll make sure it goes to the most important thing: my snack fund\"\n");
    }
}
