package com.intellias.lesson33;

public class ForkJoinDemo {
    public static void main(String[] args) {
        int len = 100_000_000;
        int[] array = new int[len];

        long localSum = 0;
        for (int i = 0; i < len; i++) {
            int randomValue = (int) (Math.random() * 100);
            array[i] = randomValue;
            localSum += randomValue;
        }

        long sumArray = SumTask.sumArray(array);
        System.out.println("localSum: " + localSum);
        System.out.println("ForkJoin: " + sumArray);
    }
}
