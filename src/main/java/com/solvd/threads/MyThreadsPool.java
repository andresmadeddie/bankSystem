package com.solvd.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    public static void getAndCountAllCurrentThreads() {
        System.out.println("\n----------\nNumber of active Threads: " + Thread.activeCount() + "\nActive Thread Names: ");
        Thread.getAllStackTraces().keySet().forEach(thread -> {
                    if (!thread.isDaemon()) {
                        System.out.println("- " + thread.getName() + " | Priority: " + thread.getPriority());
                    }
                });
        System.out.println("----------\n");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Check current Threads
//        getAndCountAllCurrentThreads();

        // Create Pool
        getExecutorService();

        // Adding 6 task to that pool
        for (int i = 0; i < 6; i++) {
            int counter = i + 1;
            executorService.submit(() -> {
                try {
                    System.out.println("Begin of Thread: " + Thread.currentThread().getId()
                            + " loop: " + counter);
                    Thread.sleep(5000);
                    System.out.println("End of Thread id: " + Thread.currentThread().getId()
                            + " loop: " + counter);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
        }

        Future<String> future = executorService.submit(() -> {
            try {
                System.out.println("Callable Task begins");
                Thread.sleep(100);
                System.out.println("Callable Task ends");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Callable Result retrieved";
        });

        //This should made wait the main thread to wait until callable is done.
        System.out.println("Future return: " + future.get());

        executorService.shutdown();

        //Check current Threads
//        getAndCountAllCurrentThreads();

        System.out.println("\nTHIS IS THE ------" + Thread.currentThread().getName() + "------ THREAD");

        //Check current Threads
//        getAndCountAllCurrentThreads();
    }

}
