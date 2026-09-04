package main.java.string.assignment_problems;
public class wordreverse {
    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");// Split the sentence into words
        StringBuilder result = new StringBuilder();// StringBuilder to build the final result
        // Loop through each word in the sentence
        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder();
            String word = words[i];
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }
            result.append(reversedWord);// Append the reversed word to the result
            if (i != words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();// Convert StringBuilder to String and return
    }
    public static void main(String[] args){
        String sentence = "Hello club";// Example sentence to reverse each word
        String reversedSentence = reverseEachWord(sentence);// Call the method to reverse each word
        System.out.println("Original: " + sentence);
        System.out.println("Reversed: " + reversedSentence);
    }
}
