package main.java.string.assignment_problems;

import java.util.*;

abstract class Ticket {
    protected static final double CONVENIENCE_FEE = 20;
    protected final int count;
    Ticket(int count) { 
        this.count = count; 
    }
    abstract double price();
    final double amount() { 
        return count * (price() + CONVENIENCE_FEE); 
    }
}
class RegularTicket extends Ticket {
    RegularTicket(int c) { 
        super(c); 
    }
    double price() { 
        return 150; 
    }
}
class PremiumTicket extends Ticket {
    PremiumTicket(int c) { 
        super(c); 
    }
    double price() { 
        return 250; 
    }
}
class ReclinerTicket extends Ticket {
    ReclinerTicket(int c) { 
        super(c); 
    }
    double price() { 
        return 400; 
    }
}
public class Assignment1_MovieTicket {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            int c = Integer.parseInt(t[1]);
            Ticket tk = null;
            switch (t[0]) {
                case "REGULAR": tk = new RegularTicket(c); break;
                case "PREMIUM": tk = new PremiumTicket(c); break;
                case "RECLINER": tk = new ReclinerTicket(c); break;
            }
            System.out.printf("%s: %.2f%n", t[0], tk.amount());
            total += tk.amount();
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
