package main.java.string.assignment_problems;
public class libraryvalid {
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();//trim is used to remove leading and trailing whitespace from the input string. This ensures that any extra spaces at the beginning or end of the input do not affect the validation and formatting process.
        if (trimmed.length() < 3) {
            return trimmed; // too short, validation step will catch this
        }
        String pubCode = trimmed.substring(0, 3).toUpperCase();//substring(0, 3) extracts the first three characters of the trimmed string, which represent the publisher code. The toUpperCase() method converts these characters to uppercase to ensure consistency in formatting.
        String rest = trimmed.substring(3);//substring(3) extracts the remaining part of the trimmed string starting from index 3 to the end. This represents the rest of the code after the publisher code.
        return pubCode + rest;//concatenates the uppercase publisher code with the remaining part of the string (rest) and returns the normalized code.
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
