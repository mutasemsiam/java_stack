import java.util.Random;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
public class PuzzleJava{

    public ArrayList getTenRolls(){
        // int [] arr;
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        // arr = new int[10];
        Random number = new Random();
        for (int i = 0; i < 10; i++){
        myArray.add(number.nextInt(21 - 1) + 1);
        }
        return myArray;
    }
    public char getRandomLetter(){
        char [] arr = new char[26];
        for(int i = 0; i < 26 ; i++){
        arr[i] = (char)('a' + i);
}
//     return arr;
//     public ArrayList getRandomLetter(){
//         ArrayList<Character> arr = new ArrayList<Character>();
//         for(int i = 0; i < 26 ; i++){
//         arr.add((char)('a' + i));
// }
    // return arr;
    // char [] arr2 = new char[26];

     Random r = new Random();
    //  for(int i = 0; i < 26 ; i++){
        char letter = arr[(r.nextInt(21 - 1) + 1)] ;
     
        // int randomChar = r.nextInt(26);
        // int chosenChar = arr[randomChar];
        // char convertedChar = (char)chosenChar;
        return letter;


    }
    public String generatePassword(){
        String randomPassword = "";
        for (int i = 0; i < 8; i++){
            randomPassword += getRandomLetter();
        } 
        return randomPassword;
    }
    public String [] getNewPasswordSet(int length){
        String [] myArray = new String[length];
        for (int i = 0; i < length; i++){
            myArray[i] = generatePassword();
        }
        return myArray;
    }

}