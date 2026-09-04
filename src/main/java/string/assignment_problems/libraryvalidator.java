package main.java.string.assignment_problems;

public class libraryvalidator {
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed; // too short, validation step will catch this
        }
        String pubCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return pubCode + rest;
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        String pubCode = code.substring(0, 3);
        for (int i = 0; i < pubCode.length(); i++) {
            if (!Character.isLetter(pubCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String body = code.substring(3); // 4 digit year + 6 digit catalog number
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining 10 characters must be digits";
            }
        }

        String year = code.substring(3, 7);      // 20XX
        String catalog = code.substring(7, 13);  // 123456

        StringBuilder display = new StringBuilder();
        display.append("[").append(pubCode).append("] ");
        display.append("YEAR: ").append(year);
        display.append(" | CATALOG: ").append(catalog);

        return display.toString();
    }
    public static void main(String[] args){
        String raw1 = " pen2026004251 ";
        String normalized1 = normalizeCode(raw1);
        System.out.println(validateAndFormat(normalized1));

        String raw2 = "12N2026004251";
        String normalized2 = normalizeCode(raw2);
        System.out.println(validateAndFormat(normalized2));
    }
}
