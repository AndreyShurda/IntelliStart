package com.intellias.lesson33.blocking.queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
                Message message = new Message("msg: " + i);
                queue.put(message);
                System.out.println("Producer: " + message);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            queue.put(new Message("exit"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
