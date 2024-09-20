package com.solvd.threads;

import java.util.concurrent.*;

public class MyThreadsPool {
    private static volatile ExecutorService executorService;

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

        getExecutorService();

        for (int i = 0; i < 6; i++) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task executed by executor: " + Thread.currentThread().getId());
            });
        }

        Callable<String> callable = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Callable executes now";
        };

        Future<String> future = executorService.submit(callable);

        System.out.println(future.get());

        executorService.shutdown();

        System.out.println("\nTHIS IS THE ------" + Thread.currentThread().getName() + "------ THREAD");
    }

}
