package main.java.com.solvd.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CheckReading {

    public static void readCheck() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nInsert check");
        String check = scan.next();

        try (BufferedReader reader = new BufferedReader(new FileReader(check))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Check can't be read\n" + e.getMessage());
        }
    }
}
