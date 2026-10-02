import java.util.*;

public class Problem1{ 
    static abstract class Payment {
        protected final double amount;
        Payment(double amount) { this.amount = amount; }
        abstract String label();
        abstract double finalAmount();
    }
    static class Card extends Payment {
        Card(double a) { super(a); }
        String label() { return "CARD"; }
        double finalAmount() { return amount * 1.02; }
    }
    static class Wallet extends Payment {
        Wallet(double a) { super(a); }
        String label() { return "WALLET"; }
        double finalAmount() { return amount * 1.01; }
    }
    static class BankTransfer extends Payment {
        BankTransfer(double a) { super(a); }
        String label() { return "BANKTRANSFER"; }
        double finalAmount() { return amount; }
    }

    static Payment create(String type, double amt) {
        switch (type) {
            case "CARD":   return new Card(amt);
            case "WALLET": return new Wallet(amt);
            default:       return new BankTransfer(amt);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(create(sc.next().toUpperCase(), sc.nextDouble()));

        double total = 0;
        for (Payment p : list) {
            double f = p.finalAmount();
            total += f;
            System.out.printf(Locale.US, "%s: %.2f%n", p.label(), f);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}