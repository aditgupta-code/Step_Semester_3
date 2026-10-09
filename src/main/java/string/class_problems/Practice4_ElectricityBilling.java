import java.util.*;
abstract class Connection {
    protected final double units;
    Connection(double units){ 
        this.units = units; 
    }
    abstract double bill();
}
class HomeConnection extends Connection {
    HomeConnection(double u){ 
        super(u); 
    }
    double bill() {
        if (units <= 100){ 
            return units * 5;
        }
        return 100 * 5 + (units - 100) * 7;
    }
}
class ShopConnection extends Connection {
    ShopConnection(double u){ 
        super(u); 
    }
    double bill(){ 
        return units * 8 + 100; 
    }
}

class FactoryConnection extends Connection {
    FactoryConnection(double u){ 
        super(u); 
    }
    double bill(){ 
        return Math.max(units * 6, 1000); 
    }
}

public class Practice4_ElectricityBilling {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double u = Double.parseDouble(t[1]);
            Connection c = null;
            switch (t[0]) {
                case "HOME": c = new HomeConnection(u); break;
                case "SHOP": c = new ShopConnection(u); break;
                case "FACTORY": c = new FactoryConnection(u); break;
            }
            System.out.printf("%s: %.2f%n", t[0], c.bill());
            total += c.bill();
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
