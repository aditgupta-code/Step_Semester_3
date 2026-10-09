import java.util.*;

abstract class LibraryItem {
    protected final String title;
    protected final int daysLate;
    LibraryItem(String title, int daysLate){ 
        this.title = title; this.daysLate = daysLate; 
    }
    abstract double fine();
}
class Book extends LibraryItem {
    Book(String t, int d){ 
        super(t, d); 
    }
    double fine(){ 
        return 2.0 * daysLate; 
    }
}
class Dvd extends LibraryItem {
    Dvd(String t, int d){ 
        super(t, d); 
    }
    double fine() { 
        return Math.min(5.0 * daysLate, 50.0); 
    }
}
class Magazine extends LibraryItem {
    Magazine(String t, int d){ 
        super(t, d); 
    }
    double fine() { 
        return 1.0 * daysLate; 
    }
}
public class Practice3_LibraryFine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            int d = Integer.parseInt(t[2]);
            LibraryItem item = null;
            switch (t[0]) {
                case "BOOK": item = new Book(t[1], d); break;
                case "DVD": item = new Dvd(t[1], d); break;
                case "MAGAZINE": item = new Magazine(t[1], d); break;
            }
            System.out.printf("%s: %.2f%n", item.title, item.fine());
            total += item.fine();
        }
        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
