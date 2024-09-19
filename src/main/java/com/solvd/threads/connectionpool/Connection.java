package com.solvd.threads.connectionpool;

class Connection {
    private final int id;

    public Connection(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void connect() {
        System.out.println("Connection " + id + " is active.");
    }

    public void close() {
        System.out.println("Connection " + id + " is closed.");
    }
}
