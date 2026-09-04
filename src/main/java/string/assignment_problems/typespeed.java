package main.java.string.assignment_problems;
public class typespeed {
    static void checkTypingAccuracy(String original, String typed) {
        System.out.println("\n--- Typing Speed Test Accuracy Checker ---");
        int length = original.length();
        int matched = 0;
        int firstMismatchIndex = -1;
        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchIndex == -1) {
                firstMismatchIndex = i;
            }
        }
        double accuracy = (matched / (double) length) * 100;
        if (firstMismatchIndex == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, length, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, length, accuracy, firstMismatchIndex + 1,
                    original.charAt(firstMismatchIndex), typed.charAt(firstMismatchIndex));
        }
    }
    public static void main(String[] args) {
        String originalText = "The quick brown fox jumps over the lazy dog.";
        String typedText = "The quick brown fox jumps over the lazy dog.";
        checkTypingAccuracy(originalText, typedText);
    }
}
