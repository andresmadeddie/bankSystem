package com.solvd.threads;

import java.util.concurrent.*;

public class MyThreadsPool {
    private static volatile ExecutorService executorService;

    // Lazy initialization using double lock
    public static void getExecutorService() {
        if (executorService == null) {
            synchronized (MyThreadsPool.class) {
                if (executorService == null) {
                    executorService = Executors.newFixedThreadPool(5);
                }
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        // Create Pool
        getExecutorService();

        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread id: " + Thread.currentThread().getId()
                    + " loop: " + 7);
            return "Callable executes now";
        });

        // Adding 6 task to that pool
        for (int i = 0; i < 6; i++) {
            int counter = i + 1;
            executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread id: " + Thread.currentThread().getId()
                + " loop: " + counter);
            });
        }

        //This should made wait the main thread to wait until callable is done.
        System.out.println(future.get());

        executorService.shutdown();

        System.out.println("\nTHIS IS THE ------" + Thread.currentThread().getName() + "------ THREAD");
    }

}
