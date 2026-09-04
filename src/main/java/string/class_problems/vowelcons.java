package main.java.string.class_problems;

public class vowelcons {
    static void countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toLowerCase(text.charAt(i));// Convert to lowercase for uniformity
            if (ch == ' ') {
                continue;// Skip spaces
            }
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;// Increment vowel count
            } else if (Character.isLetter(ch)) {
                consonants++;// Increment consonant count
            }
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }
    public static void main(String[] args) {
        String text = "Java Programming";// Example input
        countVowelsAndConsonants(text);
    }
}
