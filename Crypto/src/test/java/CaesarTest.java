import org.junit.Assert;
import org.junit.Test;

public class CaesarTest {

    @Test
    public void encryptionDecryptionTest1(){
        CaesarCipher caesar = new CaesarCipher(1);
        String plaintext = "ABCDEF";
        String expected1 = "BCDEFG";

        String actual1 = caesar.encrypt(plaintext);
        Assert.assertEquals(expected1, actual1);

        String actual2 = caesar.decrypt(actual1);
        Assert.assertEquals(plaintext, actual2);
    }

    @Test
    public void encryptionDecryptionTest24(){
        CaesarCipher caesar = new CaesarCipher(25);
        String plaintext = "ABCDEF";
        String expected1 = "ZABCDE";

        String actual1 = caesar.encrypt(plaintext);
        Assert.assertEquals(expected1, actual1);

        String actual2 = caesar.decrypt(actual1);
        Assert.assertEquals(plaintext, actual2);
    }
}
