package main.java.string.assigment_problems;
import java.time.LocalDate;
import java.util.*;
public class Problem5{
    static abstract class Plan{
        protected final String name;
        protected final LocalDate start;
        Plan(String name, LocalDate start){ 
            this.name = name; 
            this.start = start; 
        }
        String getName(){ 
            return name; 
        }
        abstract int validityDays();
        LocalDate renewalDate(){ 
            return start.plusDays(validityDays()); 
        }
    }
    static class Basic extends Plan {
        Basic(String n, LocalDate s){ 
            super(n, s); 
        }
        int validityDays(){ 
            return 30; 
        }
    }
    static class Standard extends Plan {
        Standard(String n, LocalDate s){ 
            super(n, s); 
        }
        int validityDays(){ 
            return 90; 
        }
    }
    static class Premium extends Plan {
        Premium(String n, LocalDate s){ 
            super(n, s); 
        }
        int validityDays(){ 
            return 365; 
        }
    }
    static Plan create(String type, String name, LocalDate d) {
        switch (type) {
            case "BASIC":    return new Basic(name, d);
            case "STANDARD": return new Standard(name, d);
            default:         return new Premium(name, d);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plan> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            list.add(create(type, name, LocalDate.parse(sc.next())));
        }
        for (Plan p : list) System.out.println(p.getName() + ": " + p.renewalDate());
        sc.close();
    }
}