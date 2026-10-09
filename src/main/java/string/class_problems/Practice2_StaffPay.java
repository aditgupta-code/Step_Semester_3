import java.util.*;

abstract class StaffMember {
    protected final String name;
    StaffMember(String name) { this.name = name; }
    abstract double pay();
}

class FullTime extends StaffMember {
    private final double salary;
    FullTime(String n, double s) { super(n); salary = s; }
    double pay() { return salary; }
}

class Hourly extends StaffMember {
    private final double hours, rate;
    Hourly(String n, double h, double r) { super(n); hours = h; rate = r; }
    double pay() {
        if (hours <= 40) return hours * rate;
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class Intern extends StaffMember {
    private final double stipend;
    Intern(String n, double s) { super(n); stipend = s; }
    double pay() { return stipend; }
}

public class Practice2_StaffPay {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            StaffMember s = null;
            switch (t[0]) {
                case "FULLTIME": s = new FullTime(t[1], Double.parseDouble(t[2])); break;
                case "HOURLY": s = new Hourly(t[1], Double.parseDouble(t[2]), Double.parseDouble(t[3])); break;
                case "INTERN": s = new Intern(t[1], Double.parseDouble(t[2])); break;
            }
            System.out.printf("%s: %.2f%n", s.name, s.pay());
            total += s.pay();
        }
        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}
