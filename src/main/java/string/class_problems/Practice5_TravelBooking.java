import java.util.*;

abstract class Booking {
    protected static final double BOOKING_FEE = 50;
    protected final double distanceKm;
    Booking(double distanceKm){ 
        this.distanceKm = distanceKm; 
    }
    abstract double baseFare();
    final double total() { 
        return baseFare() + BOOKING_FEE; 
    }
}
class BusBooking extends Booking {
    BusBooking(double d) { 
        super(d); 
    }
    double baseFare(){ 
        return 2 * distanceKm; 
    }
}
class TrainBooking extends Booking {
    TrainBooking(double d) { super(d); }
    double baseFare(){ 
        return 1.5 * distanceKm; 
    }
}
class FlightBooking extends Booking {
    FlightBooking(double d) { super(d); }
    double baseFare(){ 
        return 2500 + 4 * distanceKm; 
    }
}
public class Practice5_TravelBooking {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double d = Double.parseDouble(t[1]);
            Booking b = null;
            switch (t[0]) {
                case "BUS": b = new BusBooking(d); break;
                case "TRAIN": b = new TrainBooking(d); break;
                case "FLIGHT": b = new FlightBooking(d); break;
            }
            System.out.printf("%s: %.2f%n", t[0], b.total());
        }
        sc.close();
    }
}
