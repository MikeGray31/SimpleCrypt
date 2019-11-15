import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.Character.*;

public class ROT13  {

    Character cs;
    Character cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
        this.cs = 'a';
        this.cf = 'm';
    }

    String crypt(String text) throws UnsupportedOperationException {
        return shiftThis(text,this.cf, 1);
    }

    String encrypt(String text) {
        return shiftThis(text, this.cf,1);
    }

    String decrypt(String text) {
        return shiftThis(text, this.cf,-1);
    }

    private static Integer getShift(Character c, int backOrForwards){
        if(c > 64 && c < 91){
            return (backOrForwards/Math.abs(backOrForwards))*(c - 65);
        }
        else if(c > 96 && c < 123){
            return (backOrForwards/Math.abs(backOrForwards))*(c - 97);
        }
        else{
            return 0;
        }
    }

    private static String shiftThis(String text, Character c ,int backwardsOrForwards) throws UnsupportedOperationException {
        int shift = getShift(c, backwardsOrForwards);
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


    public static String rotate(String s, Character c) {
        int shift = getShift(c, 1);
        String result = "";

        for(int i = s.length() - shift; i < s.length(); i++){
            result += s.charAt(i);
        }
        for(int i = 0; i < s.length() - shift; i++){
            result+= s.charAt(i);
        }
        return result;
    }

    public String cryptFile(){
        try {
            String fileText = new String(Files.readAllBytes(Paths.get("/Users/mike/Desktop/dev/Week 5/SimpleCrypt/sonnet18.txt")));
            return crypt(fileText);
        }
        catch (Exception e){
            return "";
        }
    }
}
