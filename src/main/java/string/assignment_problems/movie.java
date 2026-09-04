package main.java.string.assignment_problems;

public class movie {
    static void classifyWordLengths(String review) {
        System.out.println("\n--- Movie Review Word Length Profiler ---");

        String[] words = review.split("\\s+");
        int shortCount = 0, mediumCount = 0, longCount = 0;

        for (String word : words) {
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }
    public static void main(String[] args){
        String review = "This movie was absolutely fantastic and thrilling";
        classifyWordLengths(review);
    }
}
