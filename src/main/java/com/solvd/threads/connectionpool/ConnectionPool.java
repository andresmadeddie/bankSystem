package com.solvd.threads.connectionpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ConnectionPool {
    private static ConnectionPool instance;
    private final BlockingQueue<Connection> pool;

    private ConnectionPool(int poolSize) {
        pool = new LinkedBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            pool.add(new Connection(i + 1));
        }
    }

    public static synchronized ConnectionPool getInstance(int poolSize) {
        if (instance == null) {
            instance = new ConnectionPool(poolSize);
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        return pool.take();  // This will wait if no connections are available
    }

    public void releaseConnection(Connection connection) {
        pool.offer(connection);
    }
}
