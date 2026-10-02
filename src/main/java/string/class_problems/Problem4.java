import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Problem4{
    static abstract class Question {
        protected final String text, correct, student;
        protected final double points;
        Question(String text, String correct, String student, double points) {
            this.text = text; this.correct = correct; this.student = student; this.points = points;
        }
        abstract String label();
        abstract double score();
    }
    static class Mcq extends Question {
        Mcq(String t, String c, String s, double p) { super(t, c, s, p); }
        String label() { return "MCQ"; }
        double score() { return student.equals(correct) ? points : 0; }
    }
    static class TrueFalse extends Question {
        TrueFalse(String t, String c, String s, double p) { super(t, c, s, p); }
        String label() { return "TF"; }
        double score() { return student.equals(correct) ? points : 0; }
    }
    static class Essay extends Question {
        Essay(String t, String c, String s, double p) { super(t, c, s, p); }
        String label() { return "ESSAY"; }
        double score() {
            String answer = student.toLowerCase();
            int matched = 0;
            for (String kw : correct.toLowerCase().split(",")) {
                kw = kw.trim();
                if (!kw.isEmpty() && answer.contains(kw)) matched++;
            }
            if (matched >= 2) return points * 0.75;
            if (matched == 1) return points * 0.50;
            return 0;
        }
    }
    static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        Matcher m = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        while (m.find()) tokens.add(m.group(1) != null ? m.group(1) : m.group(2));
        return tokens;
    }
    static Question create(List<String> t) {
        String type = t.get(0).toUpperCase();
        double pts = Double.parseDouble(t.get(4));
        switch (type) {
            case "MCQ": return new Mcq(t.get(1), t.get(2), t.get(3), pts);
            case "TF":  return new TrueFalse(t.get(1), t.get(2), t.get(3), pts);
            default:    return new Essay(t.get(1), t.get(2), t.get(3), pts);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Question> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(create(tokenize(br.readLine())));

        double total = 0;
        for (Question q : list) {
            double s = q.score();
            total += s;
            System.out.printf(Locale.US, "%s: %.2f%n", q.label(), s);
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
        br.close();
    }
}