package com.intellias.lesson33;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {

    public static final int MIN_SEGMENT = 20;
    private int[] array;
    private int from;
    private int to;

    public SumTask(int[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        if (to - from <= MIN_SEGMENT) {
            return sum();
        } else {
            int mid = (from + to) / 2;

            SumTask left = new SumTask(array, from, mid);
            SumTask right = new SumTask(array, mid, to);
            left.fork();

            Long rightResult = right.compute();
            Long leftResult = left.join();

            return leftResult + rightResult;
        }
    }

    public static long sumArray(int[] array) {
        return ForkJoinPool.commonPool().invoke(new SumTask(array, 0, array.length));
    }

    private Long sum() {
        long sum = 0;
        for (int i = from; i < to; i++) {
            sum += array[i];
        }
        return sum;
    }
}
