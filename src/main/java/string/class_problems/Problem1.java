public class Problem1 {
    static class PiggyBank{
        private double savings;
        @SuppressWarnings("unused")
        private final String id;
        public PiggyBank(String id) {
            this.id = id;
            this.savings = 0;
        }
        public void deposit(double amount) {
            if (amount > 0) {
                savings += amount;
            }
        }
        public void withdraw(double amount) {
            if (amount <= savings) {
                savings -= amount;
            }
        }
        public double getSavings() {
            return savings;
        }
    }
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("After deposit(100) -> savings = " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("After withdraw(30) -> savings = " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("After withdraw(500) [rejected] -> savings = " + pb.getSavings());
    }
}
