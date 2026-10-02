import java.util.*;

public class Problem3{
    static abstract class Delivery {
        protected final double weight, distance;
        Delivery(double w, double d) { weight = w; distance = d; }
        abstract String label();
        abstract double fee();
    }
    static class Standard extends Delivery {
        Standard(double w, double d) { super(w, d); }
        String label() { return "STANDARD"; }
        double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
    }
    static class Express extends Delivery {
        Express(double w, double d) { super(w, d); }
        String label() { return "EXPRESS"; }
        double fee() { return 15 + 1.00 * weight + 0.20 * distance; }
    }
    static class International extends Delivery {
        private final double customsFee;   // extra value lives in the subclass
        International(double w, double d, double customs) { super(w, d); customsFee = customs; }
        String label() { return "INTERNATIONAL"; }
        double fee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double w = sc.nextDouble(), d = sc.nextDouble();
            if (type.equals("STANDARD")) list.add(new Standard(w, d));
            else if (type.equals("EXPRESS")) list.add(new Express(w, d));
            else list.add(new International(w, d, sc.nextDouble()));
        }

        double total = 0;
        for (Delivery d : list) {
            double f = d.fee();
            total += f;
            System.out.printf(Locale.US, "%s: %.2f%n", d.label(), f);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}