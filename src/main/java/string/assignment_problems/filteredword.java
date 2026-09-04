package main.java.string.assignment_problems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class filteredword {
    static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};//common stop words
        String cleaned = feedback.toLowerCase();// Convert to lowercase
        cleaned = cleaned.replace(",", "").replace(".", "");// Strip punctuation
        String[] words = cleaned.split("\\s+");// Split into words and \\s+ is used to match one or more whitespace characters
        Map<String, Integer> frequency = new HashMap<>();// Map to store word frequency
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            boolean isStopWord = false;// Flag to check if the word is a stop word
            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;//if word is a stop word it breaks the loop and does not add into frequency map
                }
            }
            if (isStopWord) {
                continue;// Skip stop words
            }
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());// Sort by count descending
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());// Print the word and its frequency
        }
    }
    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
