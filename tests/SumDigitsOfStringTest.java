import org.junit.Test;

import static org.junit.Assert.*;

public class SumDigitsOfStringTest {

    @Test
    public void getSumFromDefaultString() {
        SumDigitsOfString obj = new SumDigitsOfString();
        assertEquals(6, obj.getSumFromDefaultString("abcd123"));
        assertEquals(0, obj.getSumFromDefaultString("abcd"));
        assertEquals(6, obj.getSumFromDefaultString("123"));
        assertEquals(24, obj.getSumFromDefaultString("abcd 987"));
        assertEquals(1, obj.getSumFromDefaultString("-100"));
        assertEquals(45, obj.getSumFromDefaultString("1234567890"));
        assertEquals(0, obj.getSumFromDefaultString("abcd &&(&^*%^&"));
    }
}