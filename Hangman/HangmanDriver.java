import java.io.Console;

public class HangmanDriver{

	public static void main(String[] args){
		String name = System.console().readLine("What Is Your Name? ");
		Hangman Hang = new Hangman(name);
		HangmanVisuals Visuals = new HangmanVisuals();
		HangmanDictionary Dict = new HangmanDictionary();
		System.out.println("Welcome To Hangman " + Hang.getPlayerName() + "!");
		Hang.setWord(Dict.getWord());
		do {
			System.out.print("Enter A Letter: ");
			char guessChar = System.console().readLine().charAt(0);
			if(!Hang.tryChar(guessChar)){
				System.out.println(HangmanVisuals.getPicture(Hang.getRemainingGuesses()));
			}
			System.out.println(Hang.getCurrentState() + ": You Have " + Hang.getRemainingGuesses() + " Guesses Remaining");
		} while (Hang.getRemainingGuesses() != 0 && !(Hang.getWord().equals(Hang.getCurrentState())));
		if(Hang.getCurrentState().equals(Hang.getWord())){
			System.out.println("Well Done, You Guessed Correctly");
		} else {
			System.out.println("Better Luck Next Time. The Word Was " + Hang.getWord());
		}
	}
	
}
