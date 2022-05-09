import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

public class palindromeCounter {

	public static boolean isPalindome(String s) {

		if(s.length() < 2)
		{
			return true;
		}
		else
		{
			if(s.substring(0, 1).equals(s.substring(s.length()-1, s.length())))
			{
				return isPalindome(s.substring(1, s.length()-1));
			}
			return false;
		}

	}

	public static void main(String[] args) {

		Map<String, Boolean> hashedMap = new HashMap<>();
		String textContent = "";

		try (
			BufferedReader fileContent = new BufferedReader(new FileReader(args[0]));
		)
		{
			while((textContent = fileContent.readLine()) != null)
			{
				if(hashedMap.get(textContent) == null)
				{
					if(isPalindome(textContent))
					{
						System.out.println(textContent.toUpperCase() + ": This Is A Palindrome");
						hashedMap.put(textContent, true);
					}
					else
					{
						System.out.println(textContent.toUpperCase() + ": This Is Not A Palindrome");
						hashedMap.put(textContent, false);
					}
				}
			}
			fileContent.close();
		}
		catch (Exception e)
		{
			System.out.println("Error: Could Not Find The File!");
		}

	}

}