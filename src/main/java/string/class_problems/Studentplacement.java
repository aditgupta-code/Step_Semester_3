package main.java.string.class_problems;
/**
 * Studentplacement
 */
class PlacementRecord{
    String studentName;
    String company;
    double packageLpa;
    PlacementRecord(String studentName, String company, double packageLpa){
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }
    void printRecord(){
        System.out.println(studentName + " -> "+ company + " @ " + packageLpa);
    }
}
public class Studentplacement{
    public static void main(String[] args){
        PlacementRecord[] strecord = new PlacementRecord[8];
        strecord[0] = new PlacementRecord("Ravi", "TCS", 4.5);
        strecord[1] = new PlacementRecord("Anitha", "Zoho", 6.2);
        strecord[2] = new PlacementRecord("Karthik", "Infosys", 4.0);
        System.out.println("Student Placement Records: ");
        for(int i=0; i<strecord.length; i++){
            strecord[i].printRecord();
        }
    }
}