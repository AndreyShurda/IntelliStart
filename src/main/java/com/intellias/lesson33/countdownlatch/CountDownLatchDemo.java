package com.intellias.lesson33.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int countOfWorkers = 4;
        CountDownLatch latch = new CountDownLatch(countOfWorkers);

        List<Worker> workers = createWorkers(countOfWorkers, latch);
        workers.forEach(Thread::start);

        latch.await();
//        Thread.sleep(1); for consistent print messages
        System.out.println(Thread.currentThread().getName() + " has finished");
    }

    private static List<Worker> createWorkers(int countOfWorkers, CountDownLatch latch) {
        return IntStream.range(1, countOfWorkers + 1)
                .mapToObj(i -> new Worker(1000 * i, latch, "Worker-" + i))
                .collect(Collectors.toList());
    }
}
