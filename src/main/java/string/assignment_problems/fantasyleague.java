import java.util.Arrays;
public class fantasyleague {
    static class Player implements Comparable<Player> {
        private final String name;
        private final int mp;
        private final double batavg;
        private final boolean inj;

        public Player(String name, int mp, double batavg, boolean inj) {
            this.name = name;
            this.mp = mp;
            this.batavg = batavg;
            this.inj = inj;
        }

        public String getName() {
            return name;
        }
        public double fantasyPoints() {
            return batavg;
        }
        static boolean isDraftable(int mp) {
            return mp >= 10;
        }
        static boolean isDraftable(int mp, boolean inj) {
            return mp >= 5 && !inj;
        }
        boolean qualifies() {
            return isDraftable(this.mp) || isDraftable(this.mp, this.inj);
        }
        public int compareTo(Player other) {
            return Double.compare(other.fantasyPoints(), this.fantasyPoints());
        }
    }
    static String draftAndRank(Player[] players) {
        java.util.List<Player> draftable = new java.util.ArrayList<>();
        for (Player p : players) {
            if (p.qualifies()) {
                draftable.add(p);
            }
        }
        Player[] draftableArray = draftable.toArray(new Player[0]);
        Arrays.sort(draftableArray);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            sb.append(i + 1).append(". ").append(draftableArray[i].getName());
            if (i != draftableArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}
