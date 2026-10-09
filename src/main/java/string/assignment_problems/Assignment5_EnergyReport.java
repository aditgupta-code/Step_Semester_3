package main.java.string.assignment_problems;
import java.util.*;
interface SaverMode {
    double SAVER_REDUCTION = 0.25;
    default double applySaver(double units) { return units * (1 - SAVER_REDUCTION); }
}

abstract class Appliance {
    protected static final double RATE_PER_UNIT = 8;

    abstract double powerWatts();

    double units(double hours) { return powerWatts() * hours / 1000.0; }
}

class Fridge extends Appliance {
    double powerWatts() { return 150; }
}

class AirConditioner extends Appliance implements SaverMode {
    double powerWatts() { return 1500; }
}

class Tv extends Appliance {
    double powerWatts() { return 100; }
}

class WashingMachine extends Appliance implements SaverMode {
    double powerWatts() { return 500; }
}

public class Assignment5_EnergyReport {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double hours = Double.parseDouble(t[1]);
            boolean saver = t.length > 2 && t[2].equals("SAVER");
            Appliance a = null;
            switch (t[0]) {
                case "FRIDGE": a = new Fridge(); break;
                case "AC": a = new AirConditioner(); break;
                case "TV": a = new Tv(); break;
                case "WASHER": a = new WashingMachine(); break;
            }
            double units = a.units(hours);
            if (saver) {
                if (a instanceof SaverMode) {
                    units = ((SaverMode) a).applySaver(units);
                } else {
                    System.out.println(t[0] + ": saver mode not supported");
                    continue;
                }
            }
            double cost = units * Appliance.RATE_PER_UNIT;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", t[0], units, cost);
            total += cost;
        }
        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}
