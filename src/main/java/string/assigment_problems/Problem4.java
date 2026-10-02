package main.java.string.assigment_problems;
import java.util.*;
public class Problem4 {
    static abstract class Employee {
        protected final String name;
        protected final double sal;
        Employee(String name, double sal){
            this.name = name; 
            this.sal = sal; 
        }
        String getName(){
            return name; 
        }
        abstract double bonus();
    }
    static class FullTime extends Employee {
        FullTime(String n, double s){ 
            super(n, s); 
        }
        double bonus(){ 
            return sal * 0.10; 
        }
    }
    static class PartTime extends Employee {
        PartTime(String n, double s){ 
            super(n, s); 
        }
        double bonus(){ 
            return sal * 0.05; 
        }
    }
    static class Intern extends Employee {
        Intern(String n, double s){ 
            super(n, s); 
        }
        double bonus(){ 
            return 2000.0; 
        }
    }
    static Employee create(String type, String name, double sal) {
        switch (type) {
            case "FULLTIME": return new FullTime(name, sal);
            case "PARTTIME": return new PartTime(name, sal);
            default:         return new Intern(name, sal);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            double sal = sc.nextDouble();
            list.add(create(type, name, sal));
        }
        double total = 0;
        for (Employee e : list) {
            double b = e.bonus();
            total += b;
            System.out.println(e.getName() + ": " + String.format("%.2f", b));
        }
        System.out.println("Total Bonus: " + String.format("%.2f", total));
        sc.close();
    }
}