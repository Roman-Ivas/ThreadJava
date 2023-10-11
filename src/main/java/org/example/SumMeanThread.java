package org.example;

public class SumMeanThread extends  Thread{
    private int[] array;
    private int sum;
    private double mean;

    public SumMeanThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        sum = 0;

        for (int num : array) {
            sum += num;
        }

        mean = (double) sum / array.length;
    }

    public int getSum() {
        return sum;
    }

    public double getMean() {
        return mean;
    }
}
