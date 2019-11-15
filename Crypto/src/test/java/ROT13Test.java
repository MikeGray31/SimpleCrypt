import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class ROT13Test {


    @Test
    public void rotateStringTest0() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "ABCDEF";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'A');

        // Then
        assertEquals(s2, actual);
    }

    @Test
    public void rotateStringTest1() {
        // Given
        String s1 = "ZABCDEF";
        String s2 = "DEFZABC";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'D');

        // Then
        assertEquals(s2, actual);
    }

    @Test
    public void rotateStringTest2() {
        // Given
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "NOPQRSTUVWXYZABCDEFGHIJKLM";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'N');
        System.out.println(s1);
        System.out.println(actual);
        // Then
        assertEquals(s2, actual);
    }

    @Test
    public void cryptTest1() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        String A1 = "Jul qvq gur puvpxra pebff gur ebnq?";

        String Q2 = "Gb trg gb gur bgure fvqr!";
        String A2 = "To get to the other side!";

        // When
        String actual = cipher.encrypt(Q1);
        System.out.println(Q1);
        System.out.println(A1);
        // Then
        assertEquals(A1, actual);

        // When
        String actual2 = cipher.decrypt(Q2);
        System.out.println(Q2);
        System.out.println(A2);
        // Then
        assertEquals(A2, actual2);
    }
    @Test
    public void cryptTest2() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        System.out.println(Q1);

        // When
        String actual = cipher.crypt(cipher.crypt(Q1));
        System.out.println(actual);
        // Then
        assertEquals(Q1, actual);
    }

    @Test
    public void cryptFileTest(){
        ROT13 cipher = new ROT13('a', 'n');
        try {
            String fileText = new String(Files.readAllBytes(Paths.get("/Users/mike/Desktop/dev/Week 5/SimpleCrypt/sonnet18.txt")));
            String cipheredFileText = cipher.crypt(fileText);
            PrintWriter writer = new PrintWriter("/Users/mike/Desktop/dev/Week 5/SimpleCrypt/sonnet18.enc", "UTF-8");
            writer.print(cipheredFileText);
            writer.close();
            Assert.assertEquals(fileText, cipher.cryptFile("/Users/mike/Desktop/dev/Week 5/SimpleCrypt/sonnet18.enc"));
        }
        catch (Exception e){ assertTrue(false);}
    }

}

