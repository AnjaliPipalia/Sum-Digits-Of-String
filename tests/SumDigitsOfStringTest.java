import org.junit.Test;

import static org.junit.Assert.*;

public class SumDigitsOfStringTest {

    @Test
    public void getSumFromDefaultString() {
        SumDigitsOfString obj = new SumDigitsOfString();
        assertEquals(0, obj.getSumFromDefaultString(""));
        assertEquals(6, obj.getSumFromDefaultString("abc123"));
        assertEquals(0, obj.getSumFromDefaultString("abcd"));
        assertEquals(0, obj.getSumFromDefaultString("abcabc"));
        assertEquals(12, obj.getSumFromDefaultString("123 123"));
        assertEquals(6, obj.getSumFromDefaultString("123"));
        assertEquals(24, obj.getSumFromDefaultString("abcd 987"));
        assertEquals(1, obj.getSumFromDefaultString("-100"));
        assertEquals(45, obj.getSumFromDefaultString("1234567890"));
        assertEquals(0, obj.getSumFromDefaultString("abcd &&(&^*%^&"));
    }

    @Test
    public void getHexadecimalSumFromString() {
        SumDigitsOfString obj = new SumDigitsOfString();
        assertEquals(0, obj.getHexadecimalSumFromString(""));
        assertEquals(39, obj.getHexadecimalSumFromString("abc123"));
        assertEquals(33, obj.getHexadecimalSumFromString("abc"));
        assertEquals(45, obj.getHexadecimalSumFromString("123456789"));
        assertEquals(75, obj.getHexadecimalSumFromString("ABCDEF"));
        assertEquals(75, obj.getHexadecimalSumFromString("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals(75, obj.getHexadecimalSumFromString("abcdefghijklmnopqrstuvwxyz"));
        assertEquals(1, obj.getHexadecimalSumFromString("-100"));
        assertEquals(0, obj.getHexadecimalSumFromString(",$&^$&"));
        assertEquals(33, obj.getHexadecimalSumFromString("ABC"));
        assertEquals(33, obj.getHexadecimalSumFromString("abC"));
        assertEquals(120, obj.getHexadecimalSumFromString("123456789ABCDEF"));
        assertEquals(120, obj.getHexadecimalSumFromString("123456789ABCDEFghji"));
        assertEquals(76, obj.getHexadecimalSumFromString("ffrdaad"));
    }
}