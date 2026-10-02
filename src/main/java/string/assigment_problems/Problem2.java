package main.java.string.assigment_problems;
import java.util.*;
public class Problem2{
    static abstract class Vehicle {
        protected final int hrs;
        Vehicle(int hrs){
            this.hrs = hrs;
        }
        abstract String label();
        abstract double charge();
    }
    static class Bike extends Vehicle {
        Bike(int h){
            super(h);
        }
        String label(){
            return "BIKE"; 
        }
        double charge(){
            return 10.0 * hrs; 
        }
    }
    static class Car extends Vehicle {
        Car(int h){ 
            super(h); 
        }
        String label(){
            return "CAR"; 
        }
        double charge(){ 
            return 30.0 + 20.0 * (hrs - 1);
        }
    }
    static class Truck extends Vehicle {
        Truck(int h){
            super(h); 
        }
        String label(){
            return "TRUCK"; 
        }
        double charge(){
            return Math.max(100.0, 50.0 * hrs);
        }
    }

    static Vehicle create(String type, int h) {
        switch (type) {
            case "BIKE":
                return new Bike(h);
            case "CAR":
                return new Car(h);
            default:
                return new Truck(h);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(create(sc.next().toUpperCase(), sc.nextInt()));
        }
        double total = 0;
        for (Vehicle v : list) {
            double c = v.charge();
            total += c;
            System.out.println(v.label() + ": " + c);
        }
        System.out.println("Total: " + total);
        sc.close();
    }
}