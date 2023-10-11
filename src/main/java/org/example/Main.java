package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        Task 1:
//        The user enters values into the array from the keyboard. After that, two threads are launched. The first stream
//        finds the maximum in the array. The second flow finds a minimum in the array. The calculation result is returned
//        in the main method.
//        Task 2:
//        The user enters values into the array from the keyboard. After that, two threads are launched. The first stream
//        finds the sum of array elements. The second thread finds the arithmetic mean in the array. Result
//        of calculations is returned to the main method.
        Scanner scanner = new Scanner(System.in);

        // Task 1: Find maximum and minimum in the array
//        System.out.print("Enter the size of the array: ");
//        int size = scanner.nextInt();
//        int[] array = new int[size];
//
//        System.out.println("Enter the elements of the array:");
//        for (int i = 0; i < size; i++) {
//            array[i] = scanner.nextInt();
//        }
//
//        MaxMinThread maxMinThread = new MaxMinThread(array);
//        maxMinThread.start();
//
//        try {
//            maxMinThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        int maximum = maxMinThread.getMax();
//        int minimum = maxMinThread.getMin();
//
//        System.out.println("Task 1 - Maximum: " + maximum);
//        System.out.println("Task 1 - Minimum: " + minimum);
//
//        // Task 2: Find sum and arithmetic mean in the array
//        SumMeanThread sumMeanThread = new SumMeanThread(array);
//        sumMeanThread.start();
//
//        try {
//            sumMeanThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        int sum = sumMeanThread.getSum();
//        double mean = sumMeanThread.getMean();
//
//        System.out.println("Task 2 - Sum: " + sum);
//        System.out.println("Task 2 - Arithmetic Mean: " + mean);

//        Task 3:
//        From the keyboard, the user enters the path to a file containing a set of numbers. After which two are launched
//        flows The first thread creates a new file to which it writes only the even elements of the array. The second stream
//        creates a file that writes only the odd array elements. The number of even and odd elements
//        returns to the main method.

        System.out.print("Enter the path to the input file: ");
        String inputFilePath = scanner.nextLine();

        EvenOddSplitterThread evenThread = new EvenOddSplitterThread(inputFilePath, "D:\\Java\\projects\\Thread\\src\\main\\resources\\even.txt", true);
        EvenOddSplitterThread oddThread = new EvenOddSplitterThread(inputFilePath, "D:\\Java\\projects\\Thread\\src\\main\\resources\\odd.txt", false);

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int evenCount = evenThread.getEvenCount();
        int oddCount = oddThread.getOddCount();

        System.out.println("Task 3 - Number of even elements: " + evenCount);
        System.out.println("Task 3 - Number of odd elements: " + oddCount);

        //                Task 4:
//        The user enters the path to the file and the word to search from the keyboard. After that, the flow is started. He
//        searches for that word in the file. The search result is returned to main.
        System.out.print("Enter the path to the file: ");
        String filePath = scanner.nextLine();
        System.out.print("Enter the word to search for: ");
        String wordToSearch = scanner.nextLine();

        SearchThread searchThread = new SearchThread(filePath, wordToSearch);
        searchThread.start();

        try {
            searchThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (searchThread.isWordFound()) {
            System.out.println("Task 4 - Word found in the file.");
        } else {
            System.out.println("Task 4 - Word not found in the file.");
        }
    }
}