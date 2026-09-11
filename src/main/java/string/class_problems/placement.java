package main.java.string.class_problems;
import java.util.Arrays;
public class placement {
     static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final double cgpa;
        private final int codingScore;
 
        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }
 
        public String getName() {
            return name;
        }
        public double compositeScore() {
            return (cgpa * 10) + (codingScore * 0.5);
        }
        static boolean isEligible(double cgpa) {
            return cgpa >= 7.0;
        }
        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }
        boolean qualifies() {
            return isEligible(this.cgpa) || isEligible(this.cgpa, this.codingScore);
        }
        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore(), this.compositeScore());
        }
    }
 
    static String shortlistAndRank(Candidate[] candidates) {
        java.util.List<Candidate> shortlisted = new java.util.ArrayList<>();
        for (Candidate c : candidates) {
            if (c.qualifies()) {
                shortlisted.add(c);
            }
        }
        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            sb.append(i + 1).append(". ").append(shortlistedArray[i].getName())
              .append(" (").append(shortlistedArray[i].compositeScore()).append(")");
            if (i != shortlistedArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
