package main.java.string.assigment_problems;
import java.util.*;
public class Problem1{
    static abstract class Customer {
        protected final double amt;
        Customer(double amt) {
            this.amt = amt; 
        }
        abstract String label();
        abstract double finalAmt();
    }
    static class Student extends Customer {
        Student(double amt){
            super(amt); 
        }
        String label() {
            return "STUDENT"; 
        }
        double finalAmt(){ 
            return amt * 0.90;
        }
    }
    static class Staff extends Customer {
        Staff(double amt){
            super(amt); 
        }
        String label(){
            return "STAFF"; 
        }
        double finalAmt(){
            return amt * 0.95; 
        }
    }
    static class Guest extends Customer {
        Guest(double amt){
            super(amt); 
        }
        String label(){
            return "GUEST"; 
        }
        double finalAmt(){
            return amt + 10;
        }
    }
    static Customer create(String type, double amt) {
        switch (type) {
            case "STUDENT":
                return new Student(amt);
            case "STAFF":
                return new Staff(amt);
            default:
                return new Guest(amt);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String type = sc.next().toUpperCase();
            double amt = sc.nextDouble();
            list.add(create(type, amt));
        }
        double total = 0;
        for (Customer c : list) {
            double f = c.finalAmt();
            total += f;
            System.out.printf(Locale.US, "%s: %.2f%n", c.label(), f);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}