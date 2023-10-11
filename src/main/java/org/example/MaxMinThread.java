package org.example;

public class MaxMinThread extends Thread{
    private int[] array;
    private int max;
    private int min;

    public MaxMinThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        for (int num : array) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
