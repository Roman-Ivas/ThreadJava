package org.example;

import java.io.*;

public class EvenOddSplitterThread extends Thread{
    private String inputFilePath;
    private String outputFilePath;
    private boolean isEven;
    private int evenCount;
    private int oddCount;

    public EvenOddSplitterThread(String inputFilePath, String outputFilePath, boolean isEven) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                if ((isEven && number % 2 == 0) || (!isEven && number % 2 != 0)) {
                    writer.write(String.valueOf(number));
                    writer.newLine();
                    if (isEven) {
                        evenCount++;
                    } else {
                        oddCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getEvenCount() {
        return evenCount;
    }

    public int getOddCount() {
        return oddCount;
    }
}
