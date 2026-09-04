package main.java.string.class_problems;

import java.util.HashMap;
import java.util.Map;

public class nonchar {
    static Character findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (char ch : text.toCharArray()) {
            if (freq.get(ch) == 1) return ch;
        }
        return null;
    }

    static void firstNonRepeatingDemo(String text) {
        Character result = findFirstNonRepeatingChar(text);
        System.out.println("\n--- First Non-Repeating Character: \"" + text + "\" ---");
        if (result != null) {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }
    public static void main(String[] args) {
        firstNonRepeatingDemo("swiss");
        firstNonRepeatingDemo("aabbcc");
    }
}
