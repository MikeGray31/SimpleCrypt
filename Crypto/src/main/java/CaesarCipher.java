import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.Character.*;

public class CaesarCipher  {

    private int key;

    CaesarCipher( int key) {
        this.key = key;
    }

    String encrypt(String text) {
        return shiftThis(text, key);
    }

    String decrypt(String text) {
        return shiftThis(text, -key);
    }

    private String shiftThis(String text ,int shift) throws UnsupportedOperationException {
        String result = "";

        for(int i = 0; i < text.length() ; i++){
            boolean notALetter = true;
            Character next =  text.charAt(i);
            if(isAlphabetic(text.charAt(i))){

                next =(char) (next + shift);
                while(notALetter){

                    if(isLowerCase(text.charAt(i))){
                        if(next > 'z') next = (char) (next - 26);
                        else if(next < 'a') next = (char) (next + 26);
                        else notALetter = false;
                    }
                    else if(isUpperCase(text.charAt(i))){
                        if(next > 'Z') next = (char) (next - 26);
                        else if(next < 'A') next = (char) (next + 26);
                        else notALetter = false;
                    }
                }
            }
            result = result + next;
        }
        return result;
    }
}