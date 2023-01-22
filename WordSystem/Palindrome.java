import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Palindrome {

	private List<Character> palindrome;

	public Palindrome(char[] characters){
		this.palindrome = new LinkedList<Character>();
		for(char i: characters){
			palindrome.add(new Character(i));
		}
	}

	public String toString(){
		String returnString = "";
		for(int i = 0; i < palindrome.size(); i++){
			returnString += palindrome.get(i);
		}
		return returnString;
	}

	public boolean lengthIsEven(){
		if(palindrome.size() % 2 == 0){ return true; }
		return false;
	}

	public List<Character> firstHalf(){
		List<Character> returnList;
		if(lengthIsEven()){
			returnList = palindrome.subList(0, (palindrome.size() / 2));
		} else {
			returnList = palindrome.subList(0, ((palindrome.size() - 1) / 2));
		}
		return returnList;
	}

	public List<Character> secondHalf(){
		List<Character> returnList;
		if(lengthIsEven()){
			returnList = palindrome.subList((palindrome.size() / 2), palindrome.size());
		} else {
			returnList = palindrome.subList(((palindrome.size() + 1) / 2), palindrome.size());
		}
		return returnList;
	}

	public boolean checkPalindrome(){
		Stack<Character> charStack = new Stack<Character>();
		firstHalf().forEach((Character chr) -> {
			charStack.push(chr);
		});
		for(Character chr: secondHalf()){
			if(!(charStack.pop().equals(chr))){
				return false;
			} 
		}
		return true;
	}

	public static void main(String[] args) {
		char[] charArray1 = {'a','n','n','a'};
		char[] charArray2 = {'s','y','n','e','r','g','y'};
		char[] charArray3 = {'r','a','c','e','c','a','r'};
		char[] charArray4 = {'m','i','s','s','i','n','g'};
		Palindrome[] palindromeList = {new Palindrome(charArray1), new Palindrome(charArray2), new Palindrome(charArray3), new Palindrome(charArray4)};
		for(Palindrome p: palindromeList){
			if(p.checkPalindrome()){
				System.out.println("\'" + p.toString() + "\' Is A Palindrome");
			} else {
				System.out.println("\'" + p.toString() + "\' Is Not A Palindrome");
			}
		}

	}

}