import java.util.*;
public class Problem5{
    static abstract class Journey {
        protected final double dis;
        Journey(double dis){ 
            this.dis = dis; 
        }
        abstract String label();
        abstract double fare();
    }
    static class Bus extends Journey {
        Bus(double d){ 
            super(d); 
        }
        String label(){ 
            return "BUS"; 
        }
        double fare(){ 
            return Math.min(10.0, 2 + 0.10 * dis); 
        }
    }
    static class Train extends Journey {
        Train(double d){ 
            super(d); 
        }
        String label(){ 
            return "TRAIN"; 
        }
        double fare(){ 
            return 3 + 0.15 * dis; 
        }
    }
    static class Metro extends Journey {
        private final double peakFac;
        Metro(double d, double peak) { super(d); peakFac= peak; }
        String label(){ 
            return "METRO"; 
        }
        double fare() { return (1.5 + 0.20 * dis) * peakFac; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Journey> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double d = sc.nextDouble();
            if (type.equals("BUS")) list.add(new Bus(d));
            else if (type.equals("TRAIN")) list.add(new Train(d));
            else list.add(new Metro(d, sc.nextDouble()));
        }
        double total = 0;
        for (Journey j : list) {
            double f = j.fare();
            total += f;
            System.out.printf(Locale.US, "%s: %.2f%n", j.label(), f);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}