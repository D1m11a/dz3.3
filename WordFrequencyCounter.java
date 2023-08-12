package dz35;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Map<String, Integer> wordFrequency = calculateWordFrequency("words.txt");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println("Word: " + entry.getKey() + " - Frequency: " + entry.getValue());
        }
    }

    public static Map<String, Integer> calculateWordFrequency(String fileName) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", ""); 
                    if (!word.isEmpty()) {
                        word = word.toLowerCase(); 
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return wordFrequency;
    }
}
