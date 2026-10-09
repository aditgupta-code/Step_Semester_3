package main.java.string.assignment_problems;
import java.util.*;
interface Insurable {
    double INSURANCE_RATE = 0.02;
    double declaredValue();
    default double insurance() { 
        return declaredValue() * INSURANCE_RATE; 
    }
}
abstract class Parcel {
    protected final double weightKg;
    protected final double declaredValue;
    Parcel(double w, double v) { 
        weightKg = w; declaredValue = v; 
    }
    abstract double charge();
    protected double standardCharge() { 
        return 40 + 10 * weightKg; 
    }
    double insuranceAmount() { 
        return (this instanceof Insurable) ? ((Insurable) this).insurance() : 0; 
    }
    double total() { 
        return charge() + insuranceAmount(); 
    }
}
class StandardParcel extends Parcel {
    StandardParcel(double w, double v) { 
        super(w, v); 
    }
    double charge() { 
        return standardCharge(); 
    }
}
class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double w, double v) { 
        super(w, v); 
    }
    double charge() { 
        return 80 + 15 * weightKg; 
    }
    public double declaredValue() { 
        return declaredValue; 
    }
}
class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double w, double v) { 
        super(w, v); 
    }
    double charge() { 
        return standardCharge() + 50; 
    }
    public double declaredValue() { 
        return declaredValue; 
    }
}
public class Assignment2_ParcelShipping {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double w = Double.parseDouble(t[1]), v = Double.parseDouble(t[2]);
            Parcel p = null;
            switch (t[0]) {
                case "STANDARD": p = new StandardParcel(w, v); break;
                case "EXPRESS": p = new ExpressParcel(w, v); break;
                case "FRAGILE": p = new FragileParcel(w, v); break;
            }
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    t[0], p.charge(), p.insuranceAmount(), p.total());
            grand += p.total();
        }
        System.out.printf("Grand Total: %.2f%n", grand);
        sc.close();
    }
}