package main.java.string.class_problems;

public class revcustname {
    static String reverseCustomerName(String cName) {
        return new StringBuilder(cName).reverse().toString();
    }
    static void reverseNameDemo(String cName) {
        String rName = reverseCustomerName(cName);
        System.out.println("\n--- Customer Identity Verification ---");
        System.out.println("Original Name: " + cName);
        System.out.println("Reversed Name: " + rName);
    }
    public static void main(String[] args) {
        reverseNameDemo("Sunil");
    }

}
