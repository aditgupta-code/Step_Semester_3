import java.util.*;

abstract class Plot {
    protected final String owner;
    Plot(String owner) { this.owner = owner; }
    abstract double area();
    abstract String shape();
}

class Circle extends Plot {
    private final double r;
    Circle(String o, double r) { super(o); this.r = r; }
    double area() { return Math.PI * r * r; }
    String shape() { return "CIRCLE"; }
}

class Rectangle extends Plot {
    private final double l, w;
    Rectangle(String o, double l, double w) { super(o); this.l = l; this.w = w; }
    double area() { return l * w; }
    String shape() { return "RECTANGLE"; }
}

class Triangle extends Plot {
    private final double b, h;
    Triangle(String o, double b, double h) { super(o); this.b = b; this.h = h; }
    double area() { return 0.5 * b * h; }
    String shape() { return "TRIANGLE"; }
}

public class Practice1_GardenPlot {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            switch (t[0].toUpperCase()) {   // accepts Circle / circle / CIRCLE
                case "CIRCLE":
                    plots.add(new Circle(t[1], Double.parseDouble(t[2])));
                    break;
                case "RECTANGLE":
                    plots.add(new Rectangle(t[1], Double.parseDouble(t[2]), Double.parseDouble(t[3])));
                    break;
                case "TRIANGLE":
                    plots.add(new Triangle(t[1], Double.parseDouble(t[2]), Double.parseDouble(t[3])));
                    break;
                default:
                    System.out.println("Unknown shape: " + t[0]);
            }
        }

        double total = 0;
        for (Plot p : plots) {   // report code never changes when a new shape is added
            System.out.printf("%s (%s): %.2f%n", p.owner, p.shape(), p.area());
            total += p.area();
        }
        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}