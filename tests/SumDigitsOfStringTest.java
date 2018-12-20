package tests;

import org.junit.Test;
import src.SumDigitsOfString;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

    @Test
    public void getSumFromFile() throws Exception {
        SumDigitsOfString obj = new SumDigitsOfString();

        createFile("file.tmp", "abc123");
        assertEquals(6, obj.getSumFromFile("file.tmp"));

        createFile("file2.tmp", "abcd");
        assertEquals(0, obj.getSumFromFile("file2.tmp"));

        createFile("file3.txt", "abcabc");
        assertEquals(0, obj.getSumFromFile("file3.txt"));

        createFile("file.tmp", "123 123");
        assertEquals(12, obj.getSumFromFile("file.tmp"));

        createFile("file.tmp", "123");
        assertEquals(6, obj.getSumFromFile("file.tmp"));

        createFile("file.tmp", "abcd 987");
        assertEquals(24, obj.getSumFromFile("file.tmp"));

        createFile("file.tmp", "-100");
        assertEquals(1, obj.getSumFromFile("file.tmp"));

        createFile("file.tmp", "1234567890");
        assertEquals(45, obj.getSumFromFile("file.tmp"));

        createFile("file.tmp", "abcd &&(&^*%^&");
        assertEquals(0, obj.getSumFromFile("file.tmp"));

        createFile("file.tmp", "1\n2\n3\n4");
        assertEquals(10, obj.getSumFromFile("file.tmp"));

        createFile("file.tmp", "1234");
        assertEquals(10, obj.getSumFromFile("file.tmp"));
    }

    @Test
    public void getSumFromFileWithFileNotFoundException() {
        SumDigitsOfString obj = new SumDigitsOfString();
        try {
            obj.getSumFromFile("NONEXISTENT.txt");
            fail("Expected Exception to be thrown.");
        } catch (FileNotFoundException e) {
            assertTrue(e.getMessage(), true);
        } catch (Exception e) {
            fail("Should have thrown IOException.");
        }
    }

    @Test
    public void getSumFromFileWithExtensionNotSupportedException() {
        SumDigitsOfString obj = new SumDigitsOfString();
        try {
            createFile("file.mp3", "1234");
            assertNotEquals(10, obj.getSumFromFile("file.mp3"));
            fail("Expected Exception to be thrown.");
        } catch (FileNotFoundException e){
            fail("Should have thrown the parent Exception");
        } catch (Exception e) {
            assertTrue(e.getMessage(), true);
        }
    }

    private void createFile(String fileName, String content) {
        try {
            File file = new File(fileName);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            byte[] bytes = content.getBytes();
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (IOException e) {
            fail("Exception Occurred.");
        }
    }


}
