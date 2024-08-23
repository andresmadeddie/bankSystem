package main.java.com.solvd.interfaces;

public interface Greet {
    default void greeting(){
        System.out.println("\"Hello\"\n");
    }
}
