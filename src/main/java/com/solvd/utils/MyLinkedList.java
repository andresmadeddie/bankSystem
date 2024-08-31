package com.solvd.utils;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList<T> {

    private Node head; // Head of the linked list

    // Adds new element at the end
    public void add(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode; // Store the pointer in the head node
        } else {
            // Assign pointer to "current", traverse to find NULL node, and add "current" value to it
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Remove element
    public boolean remove(T data) {
        // Validation
        if (head == null) {
            return false;
        }

        // Compare data with first element
        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }

        // Iterate still find match or end of list
        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        // Element no found
        if (current.next == null) {
            return false;
        }

        //Delete temporary pointer
        current.next = current.next.next;
        return true;
    }

    // Print all elements
    public void showAll() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Search element
    public boolean search(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Internal node class
    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Transform linkedList into ArrayList
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

}
