public class Author{

	private String name;
	private int yearOfBirth;

	Author(String AuthorName, int BirthYear){
		name = AuthorName;
		yearOfBirth = BirthYear;
	}

	public String getAuthorName(){
		return name;
	}

	public int getYearOfBirth(){
		return yearOfBirth;
	}

	public void setAuthorName(String Author){
		name = Author;
	}

	public void setYearOfBirth(int Birth){
		yearOfBirth = Birth;
	}

	public static void main(String[] args) {

	}

}
