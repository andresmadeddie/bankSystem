package com.solvd.threads.connectionpool;


import java.util.concurrent.*;

public class CompletableFutureMain {
    public static void main(String[] args) throws InterruptedException {
        final int poolSize = 5;
        final int threadPoolSize = 7;

        ConnectionPool connectionPool = ConnectionPool.getInstance(poolSize);

        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);

        Callable<Connection> connectionTask = () -> {
            Connection conn = connectionPool.getConnection();
            System.out.println(Thread.currentThread().getName() + " obtained Connection " + conn.getId());
            conn.connect();
            Thread.sleep(2000);
            conn.close();
            connectionPool.releaseConnection(conn);
            System.out.println(Thread.currentThread().getName() + " released Connection " + conn.getId());
            return conn;
        };

        // Using CompletableFuture for async behavior
        for (int i = 0; i < threadPoolSize; i++) {
            CompletableFuture.supplyAsync(() -> {
                try {
                    return connectionTask.call();
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }, executor).thenAccept(connection -> {
                System.out.println("Task completed for Connection: " + connection.getId());
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
