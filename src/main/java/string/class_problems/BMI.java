package main.java.string.class_problems;
import java.util.Random;
public class BMI {
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5){
            return "Underweight";// if the bmi is less than 18.5 it returns underweight
        }
        else if (bmi < 25) {
            return "Normal";// if the bmi is less than 25 it returns normal
        }
        else if (bmi < 30) {
            return "Overweight";// if the bmi is less than 30 it returns overweight
        }
        else {
            return "Obese";// if the bmi is greater than 30 it returns obese
        }
    }

    static void printWellnessReport(double[] h, double[] w) {
        System.out.println("\n--- Corporate Wellness Report ---");
        System.out.printf("Person\tHeight (m)\tWeight (kg)\tBMI\tStatus%n");// prints the header of the report
        for (int i = 0; i < h.length; i++) {
            double bmi = w[i] / (h[i] * h[i]);// calculates the bmi using the formula weight/(height*height)
            String status = getBmiStatus(bmi);
            System.out.printf("%-10s%-12.2f%-14.1f%-10.2f%s%n","Person " + (i + 1), h[i], w[i], bmi, status);
        }// prints the report in a formatted way
    }

    static void bmiCalculatorDemo(int teamSize) {
        Random rand = new Random(42);
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        for (int i = 0; i < teamSize; i++) {
            heights[i] = Math.round((1.50 + rand.nextDouble() * 0.45) * 100) / 100.0;
            weights[i] = Math.round((50 + rand.nextDouble() * 50) * 10) / 10.0;
        }
        printWellnessReport(heights, weights);
    }
    public static void main(String[] args) {
        bmiCalculatorDemo(10);
    }
}