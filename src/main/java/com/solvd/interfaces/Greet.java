package com.solvd.interfaces;

public interface Greet {
    default void greeting(){
        System.out.println("\"Hello\"\n");
    }
}
