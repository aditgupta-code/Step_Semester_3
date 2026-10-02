package main.java.string.assigment_problems;

import java.util.*;

public class Problem3 {
    static abstract class Room {
        protected final double units;
        Room(double units){
            this.units = units; 
        }
        abstract String label();
        abstract double bill();
    }
    static class SingleRoom extends Room {
        SingleRoom(double u){
            super(u); 
        }
        String label(){ 
            return "SINGLE"; 
        }
        double bill(){
            return units * 8; 
        }
    }
    static class SharedRoom extends Room {
        private final int ocpts;
        SharedRoom(double u, int ocpts){
            super(u); 
            this.ocpts = ocpts; 
        }
        String label(){ 
            return "SHARED"; 
        }
        double bill(){ 
            return units * 6 / ocpts; 
        }
    }
    static class AcRoom extends Room {
        AcRoom(double u){ 
            super(u); 
        }
        String label(){ 
            return "AC"; 
        }
        double bill(){ 
            return units * 10 + 200; 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++){
            String type = sc.next().toUpperCase();
            double units = sc.nextDouble();
            if (type.equals("SINGLE")){
                rooms.add(new SingleRoom(units));
            } else if (type.equals("SHARED")) {
                rooms.add(new SharedRoom(units, sc.nextInt()));
            } else {
                rooms.add(new AcRoom(units));
            }
        }
        double total = 0;
        for (Room r : rooms) {
            double b = r.bill();
            total += b;
            System.out.println(r.label() + ": " + String.format("%.2f", b));
        }
        System.out.println("Total: " + String.format("%.2f", total));
        sc.close();
    }
}