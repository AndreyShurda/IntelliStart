package com.intellias.lesson33;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(4000L);
                return "Hello";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            System.out.println("isDone: " + future.isDone());
            System.out.println("isCancelled: " + future.isCancelled());
            String s = future.get(3, TimeUnit.SECONDS);
            System.out.println(s);
            System.out.println("isDone: " + future.isDone());
            System.out.println("isCancelled: " + future.isCancelled());
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            executorService.shutdown();
            throw new RuntimeException(e);
        }

        executorService.shutdown();

    }
}
