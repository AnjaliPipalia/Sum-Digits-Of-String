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

    protected long getSumFromFile(String filePath) {
        return 0;
    }
}
