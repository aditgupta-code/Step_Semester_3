package main.java.string.class_problems;
public class fevalid {
    static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');// Find the last occurrence of '.'
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }
        String extension = filename.substring(dotIndex + 1);// Extract the file extension
        if (extension.equalsIgnoreCase("pdf")|| extension.equalsIgnoreCase("docx")|| extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }// If the extension is one of the accepted types, return "Accepted"
        return "Rejected -invalid file type";// Otherwise, return "Rejected — invalid file type"
    }
    public static void main(String[] args){
        System.out.println(validateFileExtension("Assignment1.pdf"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}
