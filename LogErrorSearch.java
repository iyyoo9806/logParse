package com.kopo.batch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogErrorSearch {
	public static void main(String[] args) {
		String filePath = "D:\\bigLogFile.log";
		String targetWord = "[Shut Down]";
		String targetWord2 = "ERROR!";
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.contains(targetWord) && !line.contains(targetWord2)) {
					String[] splitLine = line.split("]");
					System.out.println("time : " + splitLine[0].replaceAll("\\[|\\]", ""));
					System.out.println("serverName : " + splitLine[1].replaceAll("\\[|\\]", ""));
				}

			}
		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}

	}
}
