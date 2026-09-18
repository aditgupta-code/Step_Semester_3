package main.java.string.class_problems;
public class Hostelmess {
    static class MessWallet {
        private double balance;
        public MessWallet(double opening) {
            if (opening < 0) {
                System.out.println("Warning: negative opening balance given, starting at 0");
                this.balance = 0;
            } else {
                this.balance = opening;
            }
        }

        public void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid top-up amount: must be positive");
            } else {
                balance += amount;
                System.out.println("Balance after top-up: " + balance);
            }
        }

        public void deduct(double amount) {
            if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
            } else {
                balance -= amount;
                System.out.println("Balance after deduction: " + balance);
            }
        }

        public double getBalance() {
            return balance;
        }
    }
    public static void main(String[] args){
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}