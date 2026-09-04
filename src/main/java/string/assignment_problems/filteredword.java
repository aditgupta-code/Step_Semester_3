package main.java.string.assignment_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class filteredword {
    static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        // normalize: lowercase + strip punctuation
        String cleaned = feedback.toLowerCase();
        cleaned = cleaned.replace(",", "").replace(".", "");

        String[] words = cleaned.split("\\s+");

        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            boolean isStopWord = false;
            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }
            if (isStopWord) {
                continue;
            }
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        // sort by count descending
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
