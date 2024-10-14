package com.solvd.threads;

public class MyRunnableThread implements Runnable {

    private final String clientName;

    public MyRunnableThread(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println(i + " seconds for automatic logout client " + clientName + " from the withdrawal machine due not interaction");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted for client: " + clientName);
                break; // To brake the loop if this happens
            }
        }
    }
}
