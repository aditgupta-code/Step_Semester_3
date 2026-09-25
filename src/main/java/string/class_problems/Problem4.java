public class Problem4 {
    static class Locker {
        private String combination;
        @SuppressWarnings("unused")
        private final int lockerNumber;
        public Locker(int lockerNumber, String initialCode) {
            this.lockerNumber = lockerNumber;
            this.combination = initialCode;
        }
        public boolean changeCode(String currentCode, String newCode) {
            if (currentCode.equals(this.combination)) {
                this.combination = newCode;
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args){
        Locker l = new Locker(101, "1234");
        System.out.println("changeCode(\"1234\",\"5678\") -> " + (l.changeCode("1234", "5678") ? "success" : "rejected"));
        System.out.println("changeCode(\"0000\",\"9999\") -> " + (l.changeCode("0000", "9999") ? "success" : "rejected, code is still \"5678\""));
    }
}
