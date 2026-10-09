package main.java.string.assignment_problems;
import java.util.*;
interface BusUser {
    double TRANSPORT_FEE = 12000;
    default double transportFee() { return TRANSPORT_FEE; }
}
abstract class Student {
    protected final String name;
    Student(String name) { this.name = name; }
    abstract double tuition();
    double totalFee() {
        double fee = tuition();
        if (this instanceof BusUser) fee += ((BusUser) this).transportFee();
        return fee;
    }
}
class DayScholar extends Student implements BusUser {
    DayScholar(String n) { super(n); }
    double tuition() { return 40000; }
}
class Hosteller extends Student {
    Hosteller(String n) { super(n); }
    double tuition() { return 40000 + 60000; }
}
class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String n) { super(n); }
    double tuition() { return 40000 / 2.0; }
}
public class Assignment3_CollegeFee {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            Student s = null;
            switch (t[0]) {
                case "DAY_SCHOLAR": s = new DayScholar(t[1]); break;
                case "HOSTELLER": s = new Hosteller(t[1]); break;
                case "SCHOLAR": s = new ScholarshipStudent(t[1]); break;
            }
            System.out.printf("%s: %.2f%n", s.name, s.totalFee());
            total += s.totalFee();
        }
        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}