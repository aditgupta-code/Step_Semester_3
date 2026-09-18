public class Employeeinfo {
        static class EmployeeCompany {
        String empName;
        double salary;

        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        public EmployeeCompany(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }
    public static void main(String[] args) {
        new EmployeeCompany("A", 30000);
        new EmployeeCompany("B", 32000);
        new EmployeeCompany("C", 28000);
        EmployeeCompany.printCompanyInfo();
    }
}
