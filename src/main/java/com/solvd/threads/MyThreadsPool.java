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

        Thread threatUno = new Thread(() -> {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Custom thread (thread) message: " + Thread.currentThread().getId());
        });
        Thread threatDos = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Custom thread (thread) message: " + Thread.currentThread().getId());
        });
        Thread threatTres = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Custom thread (thread) message: " + Thread.currentThread().getId());
        });
        Thread threatCuatro = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Custom thread (thread) message: " + Thread.currentThread().getId());
        });
        Thread threatCinco = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Custom thread (thread) message: " + Thread.currentThread().getId());
        });
        Thread threatSeis = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Custom thread (thread) message: " + Thread.currentThread().getId());
        });
        Callable<String> callable = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Callable executes now";
        };

        getExecutorService();

        executorService = Executors.newFixedThreadPool(5);
        executorService.submit(threatUno);
        executorService.submit(threatDos);
        Future<String> future = executorService.submit(callable);
        executorService.submit(threatTres);
        executorService.submit(threatCuatro);
        executorService.submit(threatCinco);
        executorService.submit(threatSeis);

        System.out.println(future.get());

        executorService.shutdown();

        System.out.println("\nTHIS IS THE ------" + Thread.currentThread().getName() + "------ THREAD");
    }
}
