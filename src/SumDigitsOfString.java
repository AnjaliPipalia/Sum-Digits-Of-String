import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class SumDigitsOfString {

    // For default string
    protected long getSumFromDefaultString(String defaultString) {
        long sum = 0;
        String digitOnlyString = defaultString.replaceAll("[^\\d]", "");
        for (char c : digitOnlyString.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }

    // For handling hex values when flag -x is specified
    protected long getHexadecimalSumFromString(String input) {
        long sum = 0;
        String hexString = input.replaceAll("[^a-fA-F\\d]", "");
        for (char c : hexString.toCharArray()) {
            if (c >= 'a' && c <= 'f') sum += c - 'a' + 10;
            else if (c >= 'A' && c <= 'F') sum += c - 'A' + 10;
            else if (c >= '0' && c <= '9') sum += c - '0';
        }
        return sum;
    }

    protected long getSumFromFile(String filePath) throws Exception {
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

    private String readFile(String filePath) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        return new String(encoded, Charset.defaultCharset());
    }

    private String getFileExtension(String filePath) {
        String extension = "";
        int i = filePath.lastIndexOf('.');
        if (i > 0) {
            extension = filePath.substring(i + 1);
        }
        return extension;
    }
}
