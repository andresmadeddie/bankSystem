package com.solvd.interfaces;

public interface Talk {
    default void talk(){
        System.out.println("\"I am in the bankMine\"\n");
    }
}
