package main.java.string.assignment_problems;

public class warehouse {
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        System.out.println("\n--- Warehouse Inventory Balancer ---");

        int totalA = 0, totalB = 0;
        for (int qty : sectionA) totalA += qty;
        for (int qty : sectionB) totalB += qty;

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int highestQty = Integer.MIN_VALUE;
        String highestSection = "";
        int highestIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, highestQty, highestSection, highestIndex + 1);
    }
    public static void main(String[] args) {
        int[] sectionA = {50, 30, 20, 10};
        int[] sectionB = {40, 30, 20, 20};
        analyzeInventory(sectionA, sectionB);
    }
}
