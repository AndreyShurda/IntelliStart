package com.intellias.lesson33;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Philosopher extends Thread{
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        List<Thread> list = new ArrayList<>();
        list.add(new Philosopher(semaphore, "Sokrat"));
        list.add(new Philosopher(semaphore, "Aristotel'"));
        list.add(new Philosopher(semaphore, "Andrii'"));
        list.add(new Philosopher(semaphore, "Ivan'"));
        list.add(new Philosopher(semaphore, "Taras'"));
        list.add(new Philosopher(semaphore, "Iryna'"));
        list.add(new Philosopher(semaphore, "Olya'"));
        list.add(new Philosopher(semaphore, "Rita'"));

        list.forEach(Thread::start);
    }

    private Semaphore semaphore;

    private boolean isFull;
    private String name;

    public Philosopher(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        if (!isFull){
            try {
                semaphore.acquire();
                System.out.println(name + " sits down at the table");
                Thread.sleep(500);
                isFull = true;

                System.err.println(name + " ate! Leaves the table");
                semaphore.release();
                Thread.sleep(500);


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
