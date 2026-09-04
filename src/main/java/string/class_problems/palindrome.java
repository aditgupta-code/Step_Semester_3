package main.java.string.class_problems;
public class palindrome {
    static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;// left and right are initialized to the first and last index of the string
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;// if the characters at the left and right are not equal it returns false
            }
            left++;
            right--;
        }
        return true;//if they are equal it returns true
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1){
            return true;// if the length of the string is less than or equal to 1 it returns true
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)){
            return false;
        }// if the first and last characters are not equal it returns false
        //it goes through all the characters in the string and checks if they match the original string
        return isPalindromeRecursive(text.substring(1, text.length() - 1));//substring divides the string and beginIndex starts counting from 1 and goes on till length of the text
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] org = text.toCharArray();//initializes a array of char of the original text
        char[] rev = new char[org.length];//org.length gives the length of the org array and it creates a new array
        for (int i = 0; i < org.length; i++) {
            rev[i] = org[org.length - 1 - i];//this loop reverses the original array and stores it in the rev array
        }
        return new String(org).equals(new String(rev));
    }

    static void palindromeChecker(String text) {
        String resultIter = isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome";// ? is used to check if the string is true or false
        String resultRec = isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome";
        String resultArr = isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome";

        System.out.println("\n--- Palindrome Checker: \"" + text + "\" ---");
        System.out.println("Iterative: " + resultIter + ", Recursive: " + resultRec +", Array Reversal: " + resultArr);
    }
    public static void main(String[] args) {
        palindromeChecker("madam");
        palindromeChecker("hello");
    }
}
