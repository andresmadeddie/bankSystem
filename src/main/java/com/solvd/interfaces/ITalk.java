package com.solvd.interfaces;

public interface ITalk {
    default void talk(){
        System.out.println("\"I am in the bankMine\"\n");
    }
}
