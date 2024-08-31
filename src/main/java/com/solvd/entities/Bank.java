package com.solvd.entities;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static final Map<String, Branch> branches = new HashMap<>();

    public static void addBranchToBranches(String city, Branch branch) {
        branches.put(city, branch);
    }

    public static String getBranchesByCity(String city) {
        return branches.containsKey(city) ? branches.get(city).getBranchName() : "No branch found in that city.";
        }
}
