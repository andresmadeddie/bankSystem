package main.java.com.solvd.interfaces;

public interface Pay {
    default void pay() {
        System.out.println("\"Here is the money, take it\"\n");
    }
}
