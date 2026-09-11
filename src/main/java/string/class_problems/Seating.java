package main.java.string.class_problems;
public class Seating {
    static double rowAverage(int[] row){
        int sum=0;
        for(int val : row){
            sum += val;
        }
        return (double) sum/row.length;
    }
    static String classifyRows(int[][] seatingscores, int threshold){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<seatingscores.length;i++){
            double avg = rowAverage(seatingscores[i]);
            String zone = (avg<threshold) ? "Quiet zone":"Buzzing zone";
            sb.append("Row ").append(i).append(": ").append(zone);
            if (i != seatingscores.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        int[][] seatingscore = {{40,50,45},{85,90,95},{30,20,25}};
        int threshold = 60;
        System.out.println(classifyRows(seatingscore, threshold));
    }
}
