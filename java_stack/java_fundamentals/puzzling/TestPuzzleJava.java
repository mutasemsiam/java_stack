import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
        System.out.println("-----getTenRolls-----");
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
    	//..
		// Write your other test cases here.
		//..
    // char [] array = generator.getRandomLetter();
	// System.out.println(array);

    // ArrayList<Character> array = generator.getRandomLetter();
	// System.out.println(array);
    System.out.println("-----getRandomLetter-----");
    char randomLetter = generator.getRandomLetter();
		System.out.println(randomLetter);

    System.out.println("-----getPassword-----");
    String password = generator.generatePassword();
		System.out.println(password);


    System.out.println("-----getNewPasswordSet-----");
    int length = 5;
    String [] passwordList = generator.getNewPasswordSet(length);
    for (int i = 0; i < passwordList.length; i++){
			System.out.println(passwordList[i]);
		}

	}
}
