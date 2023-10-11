package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchThread extends Thread{
    private String filePath;
    private String wordToSearch;
    private boolean wordFound;

    public SearchThread(String filePath, String wordToSearch) {
        this.filePath = filePath;
        this.wordToSearch = wordToSearch;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(wordToSearch)) {
                    wordFound = true;
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isWordFound() {
        return wordFound;
    }
}
