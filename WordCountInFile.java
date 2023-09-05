package com.kopo.batch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountInFile {
    public static void main(String[] args) {
        String filePath = "D:\\checkMe.log";
        String targetWord = "checkME";
        int totalWordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");// 문자열 공백 문자 기준 분할(스페이스, 탭, 개행 등)
                for (String word : words) {
                    if (word.contains(targetWord)) {
                        totalWordCount++;
                    }
                }
                
                System.out.println("단어 갯수" + totalWordCount);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        System.out.println("전체 단어 갯수" + totalWordCount);
    }
}