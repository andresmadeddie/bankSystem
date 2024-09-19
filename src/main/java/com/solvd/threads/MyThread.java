package com.solvd.threads;

public class MyThread extends Thread {

    private final String clientName;

    public MyThread(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println(i + " seconds for automatic logout client " + clientName + " from the withdrawal machine due not interaction");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
