package com.intellias.lesson33.blocking.queue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Message message;
            while (!(message = queue.take()).getMessage().equals("exit")) {
                Thread.sleep(1000);
                System.out.println("Consumer read: " + message);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
