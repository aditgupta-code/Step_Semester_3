import java.io.*;
import java.time.LocalDate;
import java.util.*;
public class Problem2{
    static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);
    static abstract class LibraryItem {
        protected final String title;
        LibraryItem(String title){ 
            this.title = title; 
        }
        String getTitle(){ 
            return title; 
        }
        abstract int borrowDays();
        LocalDate dueDate(){ 
            return CURRENT_DATE.plusDays(borrowDays()); 
        }
    }
    static class Book extends LibraryItem {
        Book(String t){
            super(t); 
        }
        int borrowDays(){ 
            return 14; 
        }
    }
    static class Dvd extends LibraryItem {
        Dvd(String t) { super(t); }
        int borrowDays(){ 
            return 7; 
        }
    }
    static class Magazine extends LibraryItem {
        Magazine(String t){ 
            super(t); 
        }
        int borrowDays(){ 
            return 3; 
        }
    }
    static LibraryItem create(String type, String title) {
        switch (type) {
            case "BOOK": return new Book(title);
            case "DVD":  return new Dvd(title);
            default:     return new Magazine(title);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<LibraryItem> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            int sp = line.indexOf(' ');
            String type = line.substring(0, sp).toUpperCase();
            String title = line.substring(sp + 1).trim();
            if (title.length() >= 2 && title.startsWith("\"") && title.endsWith("\""))
                title = title.substring(1, title.length() - 1);
            list.add(create(type, title));
        }
        for (LibraryItem item : list) System.out.println(item.getTitle() + ": " + item.dueDate());
        br.close();
    }
}