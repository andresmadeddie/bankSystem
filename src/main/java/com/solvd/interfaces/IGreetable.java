package com.solvd.interfaces;

public interface IGreetable {
    default void greeting(){
        System.out.println("\"Hello\"\n");
    }
}
