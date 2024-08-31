package com.solvd.entities;

import java.util.LinkedList;
import java.util.Queue;

public class WaitingList {

    private Queue<String> waitingList;

    public WaitingList() {
        this.waitingList = new LinkedList<>();
    }

    // Add a person to the waiting list
    public void addToWaitingList(String personName) {
        waitingList.offer(personName);
        System.out.println(personName + " has been added to the waiting list.");
    }

    // Remove and return the next person in line from the waiting list
    public String serveNextPerson() {
        String nextPerson = waitingList.poll();
        if (nextPerson != null) {
            System.out.println(nextPerson + " has been served and removed from the waiting list.");
        } else {
            System.out.println("The waiting list is empty.");
        }
        return nextPerson;
    }

    // Peek at the next person in line without removing them
    public String peekNextPerson() {
        String nextPerson = waitingList.peek();
        if (nextPerson != null) {
            System.out.println(nextPerson + " is next in line.");
        } else {
            System.out.println("The waiting list is empty.");
        }
        return nextPerson;
    }

    // Check if the waiting list is empty
    public boolean isEmpty() {
        return waitingList.isEmpty();
    }

    // Get the size of the waiting list
    public int getListSize() {
        return waitingList.size();
    }
}
