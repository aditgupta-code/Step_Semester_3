public class matchday {
    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return row.length == 0 ? 0.0 : (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String label = (avg >= threshold) ? "Power Surge" : "Normal";
            sb.append("Match ").append(i).append(": ").append(label);
            if (i != runsPerOver.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        System.out.println(classifyMatches(runsPerOver, 8));
    }
}
