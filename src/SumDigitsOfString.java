public class SumDigitsOfString {

    // For default string
    protected long getSumFromDefaultString(String defaultString) {
        long sum = 0;
        String digitOnlyString = defaultString.replaceAll("[^\\d]", "");
        for (int i = 0; i < digitOnlyString.length(); i++) {
            sum += Character.getNumericValue(digitOnlyString.charAt(i));
        }
        return sum;
    }

    public long getHexadecimalSumFromString(String input) {
        return 0;
    }
}
