package com.solvd.interfaces;

public interface IPayable {
    default void pay() {
        System.out.println("\"Here is the money, take it\"\n");
    }
}
