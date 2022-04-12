public class Hangman{

	private String playerName, wordToGuess;
	public final int MAX_INCORRECT_GUESSES = 10;
	private char[] guesses = new char[20];

	Hangman(String Name){
		playerName = Name;
	}

	public String getPlayerName(){
		return playerName;
	}

	public void setPlayerName(String Name){
		playerName = Name;
	}

	public String getWord(){
		return wordToGuess;
	}

	public void setWord(String wordChosen){
		wordToGuess = wordChosen;
	}

	public String getCurrentState(){
		String returnString = "";
		char[] currentState = new char[wordToGuess.length()];
		for(int i = 0; i < currentState.length; i++){
			currentState[i] = '_';
		}
		for(int x = 0; x < wordToGuess.length(); x++){
			for(int y = 0; y < guesses.length; y++){
				if(guesses[y] != wordToGuess.charAt(x)){
					continue;
				} else {
					currentState[x] = wordToGuess.charAt(x);
				}
			}
		}
		for(int y = 0; y < currentState.length; y++){
			returnString += currentState[y];
		}
		return returnString;
	}

	public char[] getGuesses(){
		return guesses;
	}

	public int getRemainingGuesses(){
		int correctWords = 0;
		int assigned = 0;
		char[] wordString = new char[wordToGuess.length()];
		for(int x = 0; x < wordString.length; x++){
			wordString[x] = wordToGuess.charAt(x);
		}
		for(int x = 0; x < wordString.length; x++){
			for(int y = 0; y < guesses.length; y++){
				if(guesses[y] == wordToGuess.charAt(x)){
					correctWords++;
					break;
				}
			}
		}
		for(int x = 0; x < guesses.length; x++){
			if(guesses[x] != 0){
				assigned++;
			}
		}
		int incorrectGuesses = (MAX_INCORRECT_GUESSES - (assigned - correctWords));
		return incorrectGuesses;		
	}

	public boolean tryChar(char Guess){
		for(int x = 0; x < guesses.length; x++){
			if(guesses[x] == Guess){
				break;
			} else {
				if(guesses[x] == 0){
					guesses[x] = Guess;
					break;
				}
			}
		}
		if(wordToGuess.indexOf(Guess) != -1){
			return true;
		}
		return false;
	}

	public static void main(String[] args){}

}
