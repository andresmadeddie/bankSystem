package com.solvd.threads.connectionpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainForConnectionPool {
    public static void main(String[] args) throws InterruptedException {
        final int poolSize = 5;
        final int threadPoolSize = 7;

        // Initialize ConnectionPool with 5 connections
        ConnectionPool connectionPool = ConnectionPool.getInstance(poolSize);

        // Create a thread pool of 7 threads
        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);

        Runnable connectionTask = () -> {
            try {
                Connection conn = connectionPool.getConnection();
                System.out.println(Thread.currentThread().getName() + " obtained Connection " + conn.getId());
                conn.connect();
                Thread.sleep(2000);  // Simulate work with the connection
                conn.close();
                connectionPool.releaseConnection(conn);
                System.out.println(Thread.currentThread().getName() + " released Connection " + conn.getId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Submit 7 tasks to the thread pool
        for (int i = 0; i < threadPoolSize; i++) {
            executor.submit(connectionTask);
        }

        // Shutdown the executor
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
