package main.java.string.class_problems;

public class Studentclg {
        static class Student {
        String name;
        int attendance;

        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        public Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }
    public static void main(String[] args){
        new Student("Meera", 92);
        new Student("Aditya", 88);
        Student.printCollegeInfo();
    }
}
