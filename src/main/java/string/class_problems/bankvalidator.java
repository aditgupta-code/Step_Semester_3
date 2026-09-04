package main.java.string.class_problems;

public class bankvalidator {
    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed; // too short, validation step will catch this
        }
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        String bankCode = reference.substring(0, 3);
        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        String body = reference.substring(3); // 6 digit date + 5 digit sequence
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining 11 characters must be digits";
            }
        }

        String datePart = reference.substring(3, 9);   // ddMMyy
        String seqPart = reference.substring(9, 14);    // 5 digit sequence

        String dd = datePart.substring(0, 2);
        String mm = datePart.substring(2, 4);
        String yy = datePart.substring(4, 6);

        StringBuilder display = new StringBuilder();
        display.append("[").append(bankCode).append("] ");
        display.append("DATE: ").append(dd).append("/").append(mm).append("/").append(yy);
        display.append(" | SEQ: ").append(seqPart);

        return display.toString();
    }
    public static void main(String[] args){
        String raw1 = " hdf03022600042 ";
        String normalized1 = normalizeReference(raw1);
        System.out.println(validateAndFormat(normalized1));
        String raw2 = "12F03022600042";
        String normalized2 = normalizeReference(raw2);
        System.out.println(validateAndFormat(normalized2));
    }
}
