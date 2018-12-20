package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class SumDigitsOfString {
    public static void main(String[] args) {
        SumDigitsOfString obj = new SumDigitsOfString();

        if (args.length == 1){
            if (args[0].equals("-help")) printHelp();
            else
                System.out.println(obj.getSumFromDefaultString(args[0]));
        } else if (args.length == 2) {
            if (args[0].equals("-x")) {
                System.out.println(obj.getHexadecimalSumFromString(args[1]));
            } else if (args[0].equals("-f")) {
                try {
                    System.out.println(obj.getSumFromFile(args[1]));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    printHelp();
                }
            }
        } else {
            printHelp();
        }
    }

    // For default string
    public long getSumFromDefaultString(String defaultString) {
        long sum = 0;
        String digitOnlyString = defaultString.replaceAll("[^\\d]", "");
        for (char c : digitOnlyString.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }

    // For handling hex values when flag -x is specified
    public long getHexadecimalSumFromString(String input) {
        long sum = 0;
        String hexString = input.replaceAll("[^a-fA-F\\d]", "");
        for (char c : hexString.toCharArray()) {
            if (c >= 'a' && c <= 'f') sum += c - 'a' + 10;
            else if (c >= 'A' && c <= 'F') sum += c - 'A' + 10;
            else if (c >= '0' && c <= '9') sum += c - '0';
        }
        return sum;
    }

    public long getSumFromFile(String filePath) throws FileNotFoundException, Exception {
        if (filePath.isEmpty()) return 0;
        String extension = getFileExtension(filePath);

        Set<String> set = new HashSet<>();
        set.add("tmp");
        set.add("txt");
        if (!set.contains(extension))
            throw new Exception("'" + extension + "' File Extension Not Support. Supported extensions are " + String.join(",", set));

        String content = readFile(filePath);
        return getSumFromDefaultString(content);
    }

    private String readFile(String filePath) throws FileNotFoundException {
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(filePath));
            return new String(encoded, Charset.defaultCharset());
        } catch (IOException e) {
            throw new FileNotFoundException("File '" + filePath + "' does not exist. Please ensure that the file is in the 'src' folder.");
        }
    }

    private String getFileExtension(String filePath) {
        String extension = "";
        int i = filePath.lastIndexOf('.');
        if (i > 0) {
            extension = filePath.substring(i + 1);
        }
        return extension;
    }

    private static void printHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append("Accepted input format:\n");
        sb.append("\t(1) Usage Example: './SumDigitsOfString abc123'\t\t- To get Default Sum.\n");
        sb.append("\t(2) Usage Example: './SumDigitsOfString -x abc123'\t\t- To get Hexadecimal Sum.\n");
        sb.append("\t(3) Usage Example: './SumDigitsOfString -f file.tmp'\t- To get Sum From File.\n");
        sb.append("\t(4) Usage Example: './SumDigitsOfString -help'\t\t\t- To print the help message.");
        System.out.println(sb.toString());
    }
}
