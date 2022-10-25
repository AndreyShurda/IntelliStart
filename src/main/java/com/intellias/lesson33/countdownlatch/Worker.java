package com.intellias.lesson33.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread {
    private int delay;
    private CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch, String name) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println("counter: " + latch.getCount());
            latch.countDown();
            System.out.println("counter decremented: " + latch.getCount());
            System.out.println(Thread.currentThread().getName() + " finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        super.run();
    }
}
