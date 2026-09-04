package main.java.string.assignment_problems;

public class exam {
    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;
        System.out.println("\n--- Exam Hall Seat Duplication Checker ---");

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }
    public static void main(String[] args) {
        int[] seatNumbers = {101, 102, 103, 104, 105,101};
        checkDuplicateSeats(seatNumbers);
    }
}
