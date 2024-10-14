package com.solvd.threads.connectionpool;

class Connection {
    private final int id;
    private boolean isActive = false;

    public Connection(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void connect() {
        if (!isActive) {
            isActive = true;
            System.out.println("Connection " + id + " is active.");
        } else {
            System.out.println("Connection " + id + " is already active.");
        }
    }

    public void close() {
        if (isActive) {
            isActive = false;
            System.out.println("Connection " + id + " is closed.");
        } else {
            System.out.println("Connection " + id + " is already closed.");
        }
    }
}
