package com.solvd.threads.connectionpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ConnectionPool {
    private final BlockingQueue<Connection> pool;

    private ConnectionPool(int poolSize) {
        pool = new LinkedBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            pool.add(new Connection(i + 1));
        }
    }

    // Holder class for lazy initialization
    private static class SingletonHelper {
        private static ConnectionPool instance;

        // Lazy initialization of the ConnectionPool
        private static void initialize(int poolSize) {
            instance = new ConnectionPool(poolSize);
        }
    }

    public static ConnectionPool getInstance(int poolSize) {
        if (SingletonHelper.instance == null) {
            synchronized (ConnectionPool.class) {
                if (SingletonHelper.instance == null) {
                    SingletonHelper.initialize(poolSize);
                }
            }
        }
        return SingletonHelper.instance;
    }

    public Connection getConnection() throws InterruptedException {
        return pool.take();  // This will wait if no connections are available
    }

    public void releaseConnection(Connection connection) {
        pool.offer(connection);
    }
}
