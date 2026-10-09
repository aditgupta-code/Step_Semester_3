package main.java.string.assignment_problems;

import java.util.*;
interface NightService {
    double NIGHT_SURCHARGE = 0.20;
    default double applyNight(double fare) { return fare * (1 + NIGHT_SURCHARGE); }
}
abstract class Cab {
    protected static final double MINIMUM_FARE = 100;

    abstract double ratePerKm();

    double fare(double km) { return Math.max(km * ratePerKm(), MINIMUM_FARE); }
}
class MiniCab extends Cab {
    double ratePerKm() { return 10; }
}
class SedanCab extends Cab implements NightService {
    double ratePerKm() { return 14; }
}
class SuvCab extends Cab implements NightService {
    double ratePerKm() { return 18; }
}
public class Assignment4_CabFare {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double km = Double.parseDouble(t[1]);
            boolean night = t[2].equals("NIGHT");
            Cab cab = null;
            switch (t[0]) {
                case "MINI": cab = new MiniCab(); break;
                case "SEDAN": cab = new SedanCab(); break;
                case "SUV": cab = new SuvCab(); break;
            }
            double fare = cab.fare(km);
            if (night) {
                if (cab instanceof NightService) {
                    fare = ((NightService) cab).applyNight(fare);
                } else {
                    System.out.println(t[0] + ": night service not available");
                    continue;
                }
            }
            System.out.printf("%s: %.2f%n", t[0], fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
